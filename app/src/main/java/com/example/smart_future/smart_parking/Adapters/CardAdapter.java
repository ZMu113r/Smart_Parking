package com.example.smart_future.smart_parking.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.SwipeableCardViewHolder> {

    private List<CardModel> modelList;

    private Context context;


    public CardAdapter(List<CardModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public SwipeableCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.card_item, null);

        SwipeableCardViewHolder holder = new SwipeableCardViewHolder(view);

        return holder;
    }

    // Getters
    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public void onBindViewHolder(SwipeableCardViewHolder holder, int position) {
        if(modelList == null || modelList.size() == 0) {
            return;
        }

        // Grab view element references
        CardModel cardmodel = modelList.get(position);

        TextView garageTextView = holder.garage;
        TextView spotsLeftTextView = holder.spots_left;
        TextView arrivalTimeTextView = holder.arrival_time;
        TextView walkingTimeTextView = holder.walking_time;

        // Give them content to display
        garageTextView.setText(String.valueOf(cardmodel.getgarage()));
        spotsLeftTextView.setText(String.valueOf(cardmodel.getNumSpotsLeft()));
        arrivalTimeTextView.setText(String.valueOf(cardmodel.getTimeToArrive()));
        walkingTimeTextView.setText(String.valueOf(cardmodel.getWalkingTime()));
    }

    class SwipeableCardViewHolder extends RecyclerView.ViewHolder {
        TextView garage;
        TextView spots_left;
        TextView arrival_time;
        TextView walking_time;

        public SwipeableCardViewHolder(View itemView) {
            super(itemView);

            garage = itemView.findViewById(R.id.garage);
            spots_left = itemView.findViewById(R.id.spots_left);
            arrival_time = itemView.findViewById(R.id.arrival_time);
            walking_time = itemView.findViewById(R.id.walking_time);
        }
    }
}
