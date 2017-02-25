package com.example.bassam.khedmaapp.user.models;

/**
 * Created by bassam on 11/9/16.
 */

public class MainActivityGridViewModel {


    String gridText;

    public MainActivityGridViewModel(String gridText) {
        this.gridText = gridText;
    }

    public String getGridText() {
        return gridText;
    }

    public void setGridText(String gridText) {
        this.gridText = gridText;
    }
}
