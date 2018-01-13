package com.example.smart_future.smart_parking.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smart_future.smart_parking.R;

public class DestinationSelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_destination_selection);

        // Create list view access
        ListView lvData = findViewById(R.id.lvData);
        lvData.setOnItemClickListener(this);
    }

    // General method to show that moving between screens works
    // NEEDS TO BE CHANGED - different destinations take you to different routes
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        // Start a new activity
        Intent intent = new Intent();
        intent.setClass(this, LoadingActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
