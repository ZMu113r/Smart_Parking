package com.example.smart_future.smart_parking.Entities;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Zach on 1/4/2018.
 */

public class Garage implements Parcelable{

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

    // Parcelable implementation methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel desc, int flags) {
        desc.writeString(name);
        desc.writeString(status);
        desc.writeInt(capacity);
        desc.writeTypedList(floors);
    }

    public static final Parcelable.Creator<Garage> CREATOR = new Parcelable.Creator<Garage>() {
        public Garage createFromParcel(Parcel in) {
            return new Garage(in);
        }

        public Garage[] newArray(int size) {
            return new Garage[size];
        }
    };

    // Un-flatten parcel
    public Garage(Parcel in) {
        name = in.readString();
        status = in.readString();
        capacity = in.readInt();
        in.readTypedList(floors, Floor.CREATOR);
    }
}
