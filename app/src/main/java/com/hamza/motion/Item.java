package com.hamza.motion;

/**
 * Created by Hamza Fetuga on 12/22/2016.
 */

public class Item {

    String title;
    String descripition;

    public Item(String title, String descripition) {
        this.title = title;
        this.descripition = descripition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }
}
