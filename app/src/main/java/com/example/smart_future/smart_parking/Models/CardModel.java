package com.example.smart_future.smart_parking.Models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Zach on 1/13/2018.
 */

public class CardModel {

    public String title;

    public Drawable image;


    public CardModel(String title, Drawable image) {
        title = this.title;
        image = this.image;
    }


    // Getters
    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }


    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
