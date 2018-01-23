package com.example.smart_future.smart_parking.Entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zach on 1/4/2018.
 */

public class Spot implements Parcelable{

    private boolean status;

    public boolean getStatus() { return  status; }

    public void setStatus(boolean status) { status = this.status; }

    // Parcelable implementation methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel desc, int flags) {
        desc.writeByte((byte) (status ? 1 : 0)); // if status == true, byte == 1
    }

    public static final Parcelable.Creator<Spot> CREATOR = new Parcelable.Creator<Spot>() {
        public Spot createFromParcel(Parcel in) {
            return new Spot(in);
        }

        public Spot[] newArray(int size) {
            return new Spot[size];
        }
    };

    // Un-flatten parcel
    public Spot(Parcel in) {
        status = in.readByte() != 0; // status == true if byte != 0
    }
}
