package com.example.smart_future.smart_parking.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.smart_future.smart_parking.Entities.Destination;
import com.example.smart_future.smart_parking.R;

public class LoadingActivity extends AppCompatActivity {

    private Destination dest;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // unpack
        dest = getIntent().getExtras().getParcelable("destination");

        // Grab reference to spinner from layout
        spinner = (ProgressBar) findViewById(R.id.progressBar);

        /*** You can do magic tricks with the spinner ***/
        // spinner.setVisibility(View.GONE);
        // spinner.setVisibility(View.VISIBLE);

        // Handles loading new activity after 5 seconds
        /*** CHANGE THIS TO HAPPEN ONCE ROUTES LOAD ***/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent timedIntent= new Intent(LoadingActivity.this, RouteSelectionActivity.class);
                // repack
                timedIntent.putExtra("destination", dest);

                LoadingActivity.this.startActivity(timedIntent);
                LoadingActivity.this.finish();
            }
        }, 2000);
    }


}
