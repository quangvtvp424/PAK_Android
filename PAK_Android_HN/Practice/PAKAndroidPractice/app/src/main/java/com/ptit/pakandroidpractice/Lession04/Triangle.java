package com.ptit.pakandroidpractice.Lession04;

import android.util.Log;

/**
 * Created by bomng on 10/24/2017.dd
 */

public class Triangle extends Shape {
    private double bottom ;
    private double height;

    public Triangle(double bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }
    private final String TAG = getClass().getSimpleName();


    @Override
    public double calArea() {
        double res = (bottom*height)/2;
        Log.d(TAG, "calArea: "+ res);
        return res;
    }
}
