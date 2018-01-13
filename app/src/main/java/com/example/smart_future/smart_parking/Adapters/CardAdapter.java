package com.example.smart_future.smart_parking.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smart_future.smart_parking.Models.CardModel;
import com.example.smart_future.smart_parking.R;
import com.huxq17.swipecardsview.BaseCardAdapter;
import com.squareup.picasso.Picasso;

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
    public void onBindData(int position, View cardview) {
        if(modelList == null || modelList.size() == 0) {
            return;
        }

        // Grab view element references
        ImageView imageView = cardview.findViewById(R.id.imageView);
        TextView textView = cardview.findViewById(R.id.textView);
        CardModel cardmodel = modelList.get(position);

        // Give them content to display
        textView.setText(cardmodel.getTitle());
        Picasso.with(context).load(cardmodel.getImage()).into(imageView);
    }
}
