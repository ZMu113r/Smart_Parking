package com.example.smart_future.smart_parking.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smart_future.smart_parking.Activities.NavigationActivity;
import com.example.smart_future.smart_parking.Models.CardModel;
import com.example.smart_future.smart_parking.R;
import com.huxq17.swipecardsview.BaseCardAdapter;

import java.util.List;

/**
 * Created by Zach on 1/13/2018.
 */

public class CardAdapter extends BaseCardAdapter {

    private List<CardModel> modelList;

    private Context context;


    public CardAdapter(List<CardModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    // Getters
    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_item;
    }


    @Override
    public void onBindData(int position, View cardView) {
        if(modelList == null || modelList.size() == 0) {
            return;
        }

        // Grab view element references
        CardModel cardmodel = modelList.get(position);
        TextView garageTextView = cardView.findViewById(R.id.garage);
        TextView spotsLeftTextView = cardView.findViewById(R.id.spots_left);
        TextView arrivalTimeTextView = cardView.findViewById(R.id.arrival_time);
        TextView walkingTimeTexzView = cardView.findViewById(R.id.walking_time);

        // Give them content to display
        garageTextView.setText(String.valueOf(cardmodel.getgarage()));
        spotsLeftTextView.setText(String.valueOf(cardmodel.getNumSpotsLeft()));
        arrivalTimeTextView.setText(String.valueOf(cardmodel.getTimeToArrive()));
        walkingTimeTexzView.setText(String.valueOf(cardmodel.getWalkingTime()));
    }
}
