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
        ImageView imageView = cardView.findViewById(R.id.floor_image);
        TextView textView = cardView.findViewById(R.id.floor_number);
        CardModel cardmodel = modelList.get(position);

        // Give them content to display
        textView.setText(cardmodel.getTitle());
        imageView.setImageDrawable(cardmodel.getImage());
    }
}
