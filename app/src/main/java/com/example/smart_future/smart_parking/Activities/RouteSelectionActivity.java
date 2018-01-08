package com.example.smart_future.smart_parking.Activities;

// Use the JSON streaming API
import javax.json.Json;
import javax.json.stream.JsonParser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smart_future.smart_parking.R;

public class RouteSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_selection);
    }
}
