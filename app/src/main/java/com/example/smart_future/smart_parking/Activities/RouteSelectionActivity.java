package com.example.smart_future.smart_parking.Activities;

// Use the JSON streaming API
import javax.json.Json;
import javax.json.stream.JsonParser;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.smart_future.smart_parking.Adapters.CardAdapter;
import com.example.smart_future.smart_parking.Entities.Destination;
import com.example.smart_future.smart_parking.Entities.Garage;
import com.example.smart_future.smart_parking.Entities.User;
import com.example.smart_future.smart_parking.Models.CardModel;
import com.example.smart_future.smart_parking.R;
import com.example.smart_future.smart_parking.Remote.GeoTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huxq17.swipecardsview.SwipeCardsView;

import java.util.ArrayList;
import java.util.List;

public class RouteSelectionActivity extends AppCompatActivity {
    // UI members
    private RecyclerView recyclerView;
    private SwipeCardsView swipeCardsView;
    private CardAdapter cardAdapter;
    private ArrayList<CardModel> cardModelList = new ArrayList<>();

    // Singleton objects
    private Destination dest;
    private User currentUser;
    private ArrayList<Garage> garages;
    private ArrayList<Garage> closestGarages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_selection);

        // unpack
        Gson gs = new Gson();
        final String currentUserJSON = getIntent().getStringExtra("current user");
        String destinationJSON = getIntent().getStringExtra("destination");
        String garagesJSON = getIntent().getStringExtra("garages");
        String closestGaragesJSON = getIntent().getStringExtra("closest garages");

        currentUser = gs.fromJson(currentUserJSON, User.class);
        dest = gs.fromJson(destinationJSON, Destination.class);
        garages = gs.fromJson(garagesJSON, new TypeToken<ArrayList<Garage>>(){}.getType());
        closestGarages = gs.fromJson(closestGaragesJSON, new TypeToken<ArrayList<Garage>>(){}.getType());;

        // Grab object references from layout
        // Recycler view
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        // Get live data to display to user
        if(closestGarages.size() >= 1) {
            cardModelList.add(new CardModel(
                    closestGarages.get(0).getName(),
                    closestGarages.get(0).getCapacity(),
                    getDestinationTime(closestGarages.get(0).getName()),
                    getWalkingTime(closestGarages.get(0).getName())));
        }
        if(closestGarages.size() >= 2) {
            cardModelList.add(new CardModel(
                    closestGarages.get(1).getName(),
                    closestGarages.get(1).getCapacity(),
                    getDestinationTime(closestGarages.get(1).getName()),
                    getWalkingTime(closestGarages.get(1).getName())));
        }
        if(closestGarages.size() >= 3) {
            cardModelList.add(new CardModel(
                    closestGarages.get(2).getName(),
                    closestGarages.get(2).getCapacity(),
                    getDestinationTime(closestGarages.get(2).getName()),
                    getWalkingTime(closestGarages.get(2).getName())));
        }

        // Create adapter
        cardAdapter = new CardAdapter(currentUser, closestGarages, cardModelList, this);
        recyclerView.setAdapter(cardAdapter);
    }

    private String getDestinationTime(String garageName) {
        Location location = new Location("current location");
        location.setLatitude(currentUser.getLatitude());
        location.setLongitude(currentUser.getLongitude());

        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                location.getLatitude() + "," + location.getLongitude() +
                "&destinations=" + "UCF garage " + garageName + "&mode=driving&language=fr-FR&avoid=tolls&key=" +
                getString(R.string.google_maps_key);
        new GeoTask(RouteSelectionActivity.this).execute(url);

        return "";
    }

    private String getWalkingTime(String garageName) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                garageName + "&destinations=" + "UCF garage " + dest.getName() + "&mode=walking&language=fr-FR&avoid=tolls&key=" +
                getString(R.string.google_maps_key);
        new GeoTask(RouteSelectionActivity.this).execute(url);

        return "";
    }
}

