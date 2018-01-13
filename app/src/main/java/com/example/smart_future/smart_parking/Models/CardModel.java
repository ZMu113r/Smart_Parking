package com.example.smart_future.smart_parking.Models;

/**
 * Created by Zach on 1/13/2018.
 */

public class CardModel {

    public String title;

    public String image;


    public CardModel(String title, String image) {
        title = this.title;
        image = this.image;
    }


    // Getters
    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }


    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
