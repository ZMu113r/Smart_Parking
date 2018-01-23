package com.example.smart_future.smart_parking.Activities;

// Use the JSON streaming API
import javax.json.Json;
import javax.json.stream.JsonParser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.smart_future.smart_parking.Adapters.CardAdapter;
import com.example.smart_future.smart_parking.Entities.Destination;
import com.example.smart_future.smart_parking.Models.CardModel;
import com.example.smart_future.smart_parking.R;
import com.huxq17.swipecardsview.SwipeCardsView;

import java.util.ArrayList;
import java.util.List;

public class RouteSelectionActivity extends AppCompatActivity {

    private SwipeCardsView swipeCardsView;

    private List<CardModel> cardModelList = new ArrayList<>();

    private Destination dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_selection);

        // unpack
        dest = getIntent().getExtras().getParcelable("destination");

        // Grab object references from layout
        swipeCardsView = findViewById(R.id.swipeCardsView);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);
        getData();

        // Make clickable to move to nav screen of that route
        swipeCardsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RouteSelectionActivity.this, NavigationActivity.class);
                // re-pack
                intent.putExtra("destination", dest);

                startActivity(intent);
            }
        });
    }
    /*** CHANGE TO BE DYNAMIC WITH EACH GARAGE ***/
    private void getData() {
        cardModelList.add(new CardModel("F", 300, "5 minutes 20 seconds", "3 minutes"));
        cardModelList.add(new CardModel("H", 300, "5 minutes 20 seconds", "3 minutes"));
        cardModelList.add(new CardModel("I", 300, "5 minutes 20 seconds", "3 minutes"));

        CardAdapter cardAdapter = new CardAdapter(cardModelList, this);
        swipeCardsView.setAdapter(cardAdapter);
    }
}

