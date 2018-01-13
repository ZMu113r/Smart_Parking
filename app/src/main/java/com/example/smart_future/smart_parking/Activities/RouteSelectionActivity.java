package com.example.smart_future.smart_parking.Activities;

// Use the JSON streaming API
import javax.json.Json;
import javax.json.stream.JsonParser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smart_future.smart_parking.Adapters.CardAdapter;
import com.example.smart_future.smart_parking.Models.CardModel;
import com.example.smart_future.smart_parking.R;
import com.huxq17.swipecardsview.SwipeCardsView;

import java.util.ArrayList;
import java.util.List;

public class RouteSelectionActivity extends AppCompatActivity {

    private SwipeCardsView swipeCardsView;

    private List<CardModel> cardModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_selection);

        swipeCardsView = findViewById(R.id.swipeCardsView);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);
        getData();
    }

    private void getData() {
        cardModelList.add(new CardModel("Floor 1", "@drawable/ucf_logo.jpg"));
        cardModelList.add(new CardModel("Floor 2", "@drawable/ucf_logo.jpg"));
        cardModelList.add(new CardModel("Floor 3", "@drawable/ucf_logo.jpg"));

        CardAdapter cardAdapter = new CardAdapter(cardModelList, this);
        swipeCardsView.setAdapter(cardAdapter);
    }
}
