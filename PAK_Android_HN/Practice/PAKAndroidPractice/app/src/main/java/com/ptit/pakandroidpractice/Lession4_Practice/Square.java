package com.ptit.pakandroidpractice.Lession4_Practice;

import android.util.Log;

/**
 * Created by bomng on 10/24/2017.dd
 */

public class Square extends Shape {
    private double weight;

    public Square(double weight) {
        this.weight = weight;
    }
    private final String TAG = getClass().getSimpleName();


    @Override
    public double calArea() {
        double res = weight*weight;
        Log.d(TAG, "calArea: "+ res);
        return res;
    }

}


