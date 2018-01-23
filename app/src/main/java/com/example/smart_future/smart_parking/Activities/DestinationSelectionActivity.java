package com.example.smart_future.smart_parking.Activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Parcel;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smart_future.smart_parking.Entities.Destination;
import com.example.smart_future.smart_parking.Entities.Garage;
import com.example.smart_future.smart_parking.Entities.User;
import com.example.smart_future.smart_parking.Handlers.HttpDataHandler;
import com.example.smart_future.smart_parking.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DestinationSelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvData;

    private Destination dest = new Destination();

    private ArrayList<Garage> garages = new ArrayList<>();

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_destination_selection);

        // Get current user from intent
        currentUser = getIntent().getExtras().getParcelable("currentUser");

        // Create list view access
        lvData = findViewById(R.id.lvData);
        lvData.setOnItemClickListener(this);
    }

    // General method to show that moving between screens works
    // NEEDS TO BE CHANGED - different destinations take you to different routes
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        // get name from clicked item
        String selectedDestination = lvData.getItemAtPosition(position).toString();
        dest.setName(selectedDestination);

        // Add Orlando, FL specification to location
        selectedDestination = "UCF " + selectedDestination + " Orlando, FL 32816";

        // Spin up an async task to...
        // Retrieve coordinates and put them into Destination object
        // in the background
        new GetCoordinates().execute(selectedDestination.replace(" ", "+"));
    }

    private class GetCoordinates extends AsyncTask<String, Void, String> {
        ProgressDialog dialog = new ProgressDialog(DestinationSelectionActivity.this, R.style.ProgressDialogTheme);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Please wait...");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String response = null;
            try {
                String address = strings[0];

                HttpDataHandler http = new HttpDataHandler();

                String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s", address);

                response = http.getHttpData(url);

                //onPostExecute(response);

                return  response;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);

                String lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lat").toString();
                String lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lng").toString();

                dest.setLatitude(Double.parseDouble(lat));
                dest.setLongitude(Double.parseDouble(lng));

                // Find best garages for chosen destination
                garages = findClosestGarages();

                // Create a new activity intent
                Intent intent = new Intent();
                intent.setClass(DestinationSelectionActivity.this, RouteSelectionActivity.class);

                // Pass in chosen destination
                intent.putExtra("destination", dest);
                // Pass in list of garages
                intent.putParcelableArrayListExtra("garages", garages);

                startActivity(intent);

            } catch (JSONException je) {
                je.printStackTrace();
            }
        }
    }

    // Method used to find 3 best garages for chosen destination
    private ArrayList<Garage> findClosestGarages() {
        ArrayList<Garage> garages = new ArrayList<>();
        return garages;
    }
}
