package com.example.smart_future.smart_parking.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
import com.example.smart_future.smart_parking.Handlers.DestinationSortingHandler;
import com.example.smart_future.smart_parking.Handlers.UserLocationSortingHandler;
import com.example.smart_future.smart_parking.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class DestinationSelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvData;

    private Destination dest = new Destination();

    private ArrayList<Garage> garages = new ArrayList<>();

    ArrayList<Garage> closestGarages = new ArrayList<>();

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_destination_selection);


        // Get current user from intent
        Gson gs = new Gson();
        String currentUserJSON = getIntent().getStringExtra("current user");
        currentUser = gs.fromJson(currentUserJSON, User.class);


        // Create list view access
        lvData = findViewById(R.id.lvData);
        // Listen for a user to choose their destination
        lvData.setOnItemClickListener(this);
    }

    // General method to show that moving between screens works
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
                // Get users destination
                JSONObject jsonObject = new JSONObject(s);

                String lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lat").toString();
                String lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lng").toString();

                dest.setLatitude(Double.parseDouble(lat));
                dest.setLongitude(Double.parseDouble(lng));



                // Fill list of Garages
                /*** IMPLEMENT FLOOR CREATION WITH "LIVE" SENSOR DATA ***/
                garages.add(new Garage("A", getGarageStatus(), 1623, 28.599628287126819, -81.205337047576904,
                        null));
                garages.add(new Garage("B", getGarageStatus(), 1259, 28.596894840943857, -81.199806207588182,
                        null));
                garages.add(new Garage("C", getGarageStatus(), 1852, 28.60190616876525, -81.19560050385283,
                        null));
                garages.add(new Garage("D", getGarageStatus(), 1241, 28.605372511338587, -81.197520965507493,
                        null));
                garages.add(new Garage("H", getGarageStatus(), 1284, 28.604800000000001, -81.200800000000001,
                        null));
                garages.add(new Garage("I", getGarageStatus(), 1231, 28.601134467682712, -81.205452257564559,
                        null));
                garages.add(new Garage("Libra", getGarageStatus(), 1007, 28.595600375707001, -81.196646690368652,
                        null));

                // Find best garages for chosen destination
                findClosestGarages();



                // Create a new activity intent
                Intent intent = new Intent(DestinationSelectionActivity.this, RouteSelectionActivity.class);

                // Convert objects to JSON strings
                Gson gs = new Gson();
                String currentUserJSON = gs.toJson(currentUser);
                String destinationJSON = gs.toJson(dest);
                String garagesJSON = gs.toJson(garages);
                String closestGaragesJSON = gs.toJson(closestGarages);

                // Pass the JSON strings to the next activity through intent
                intent.putExtra("current user", currentUserJSON);
                intent.putExtra("destination", destinationJSON);
                intent.putExtra("garages", garagesJSON);
                intent.putExtra("closest garages", closestGaragesJSON);

                startActivity(intent);

            } catch (JSONException je) {
                je.printStackTrace();
            }
        }
    }

    // Method used to find 3 best garages for chosen destination
    private void findClosestGarages() {
        // Get distances from every garage to destination and
        // Get distances from every garage to user's location
        for(Garage g : garages) {
            g.setDestinationDistance(Math.hypot((g.getLatitude() - dest.getLatitude()), (g.getLongitude() - dest.getLongitude())));
            g.setUserDistance(Math.hypot((currentUser.getLocation().getLatitude() - g.getLatitude()), (currentUser.getLocation().getLongitude() - g.getLongitude())));
        }


        // sort destinationDistance
        Collections.sort(garages, new DestinationSortingHandler());
        // Get 1st and 2nd items in destinationDistances as options for user
        closestGarages.add(garages.get(0));
        if(!closestGarages.contains(garages.get(1))) {
            closestGarages.add(garages.get(1));
        }


        // sort userDistance
        Collections.sort(garages, new UserLocationSortingHandler());
        // Get 1st item from userLocationDistances as option for user
        if(!closestGarages.contains(garages.get(0))) {
            closestGarages.add(garages.get(0));
        }
    }

    private String getGarageStatus() {
        String status = "open";

        // If spots taken == capacity
            // status == "full"

        return status;
    }
}
