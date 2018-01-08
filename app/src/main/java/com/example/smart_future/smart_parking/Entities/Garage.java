package com.example.smart_future.smart_parking.Entities;

import java.util.ArrayList;

/**
 * Created by Zach on 1/4/2018.
 */

public class Garage {

    private String name;
    private String status;
    private int capacity;
    private ArrayList<Floor> floors;

    // Getters
    public String getName() { return name; }

    public String getStatus() { return  status; }

    public int getCapacity() { return  capacity; }

    public ArrayList<Floor> getFloors() { return  floors; }


    // Setters
    public void setName(String name) { name = this.name; }

    public void setStatus(String status) { status = this.status; }

    public void setCapacity(int capacity) { capacity = this.capacity; }

    public void setFloors(ArrayList<Floor> floors) { floors = this.floors; }

}
