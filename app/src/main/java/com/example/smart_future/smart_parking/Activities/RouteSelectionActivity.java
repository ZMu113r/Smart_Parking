package com.example.smart_future.smart_parking.Activities;

// Use the JSON streaming API
import javax.json.Json;
import javax.json.stream.JsonParser;

import android.content.Intent;
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
        /**
        // Swipe Cards View
        swipeCardsView = findViewById(R.id.swipeCardsView);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);
        **/

        // Get live data to display to user
        if(closestGarages.size() >= 1) {
            cardModelList.add(new CardModel(
                    closestGarages.get(0).getName(),
                    closestGarages.get(0).getCapacity(),
                    getDestinationTime(),
                    getWalkingTime()));
        }
        if(closestGarages.size() >= 2) {
            cardModelList.add(new CardModel(
                    closestGarages.get(1).getName(),
                    closestGarages.get(1).getCapacity(),
                    getDestinationTime(),
                    getWalkingTime()));
        }
        if(closestGarages.size() >= 3) {
            cardModelList.add(new CardModel(
                    closestGarages.get(2).getName(),
                    closestGarages.get(2).getCapacity(),
                    getDestinationTime(),
                    getWalkingTime()));
        }

        // Create adapter
        cardAdapter = new CardAdapter(cardModelList, this);
        recyclerView.setAdapter(cardAdapter);


        /**
        // Make clickable to move to nav screen of that route
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gs = new Gson();

                String currentUserJSON = gs.toJson(currentUser);
                String destinationJSON = gs.toJson(dest);
                //String garagesJSON = gs.toJson(garages);

                Intent intent = new Intent(RouteSelectionActivity.this, NavigationActivity.class);

                // re-pack
                intent.putExtra("current user", currentUserJSON);
                intent.putExtra("destination", destinationJSON);
                //intent.putExtra("garages", garagesJSON);

                v.getContext().startActivity(intent);
            }
        });**/
    }

    private String getDestinationTime() {
        return "";
    }

    private String getWalkingTime() {
        return "";
    }
}

