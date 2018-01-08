package com.example.smart_future.smart_parking.Entities;

import java.util.ArrayList;

/**
 * Created by Zach on 1/4/2018.
 */

public class Floor {

    private ArrayList<Spot> spots;
    private int capacity;
    private int number;

    // Getters
    public ArrayList<Spot> getSpots() { return spots; }

    public int getCapacity() { return capacity; }

    public int getNumber() { return number; }


    // Setters
    public void setSpots(ArrayList<Spot> spots) { spots = this.spots; }

    public void setCapacity(int capacity) { capacity = this.capacity; }

    public void setNumber(int number) { number = this.number; }
}
