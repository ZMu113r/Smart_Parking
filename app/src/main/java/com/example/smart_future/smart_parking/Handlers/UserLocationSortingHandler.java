package com.example.smart_future.smart_parking.Handlers;

import com.example.smart_future.smart_parking.Entities.Garage;

import java.util.Comparator;

/**
 * Created by Zach on 1/25/2018.
 */

public class UserLocationSortingHandler implements Comparator<Garage> {
    @Override
    public int compare(Garage g1, Garage g2) {
        if(g1.getUserDistance() > g2.getUserDistance()) {
            return 1;
        }
        else if(g1.getUserDistance() < g2.getUserDistance()) {
            return -1;
        }
        else
            return 0;
    }
}
