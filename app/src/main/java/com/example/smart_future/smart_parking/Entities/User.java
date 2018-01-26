package com.example.smart_future.smart_parking.Entities;


import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Zach on 1/6/2018.
 */

public class User implements Parcelable, Comparable{
    private String parking_status;

    private Location location;


    public User(String parking_status, Location location) {
        this.parking_status = parking_status;

        this.location = location;
    }


    public String getParking_status() { return parking_status; }

    public Location getLocation() { return location; }


    public void setParking_status(String parking_status) { this.parking_status = parking_status; }

    public void setLocation(Location location) { this.location = location; }


    // Parcelable implementation methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel desc, int flags) {
        desc.writeString(parking_status);
        location.writeToParcel(desc, flags);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    // Un-flatten parcel
    private User(Parcel in) {
        parking_status = in.readString();
        location = Location.CREATOR.createFromParcel(in);
    }


    // Comparable implementation methods
    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}
