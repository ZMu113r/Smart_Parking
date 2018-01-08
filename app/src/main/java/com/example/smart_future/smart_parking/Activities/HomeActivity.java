package com.example.smart_future.smart_parking.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smart_future.smart_parking.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Home Screen -> Destination Selection
        Button destinationSelectionButton = findViewById(R.id.destinationSelectionButton);
        destinationSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DestinationSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
