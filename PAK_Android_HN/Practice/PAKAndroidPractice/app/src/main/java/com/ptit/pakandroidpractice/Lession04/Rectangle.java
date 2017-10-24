package com.ptit.pakandroidpractice.Lession04;

import android.util.Log;

/**
 * Created by bomng on 10/24/2017.dd
 */

public class Rectangle extends Shape {
    private double weight;
    private double height;

    public Rectangle(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    private final String TAG = getClass().getSimpleName();


    @Override
    public double calArea() {
        double res = weight*height;
        Log.d(TAG, "calArea: "+ res);
        return res;
    }
}
