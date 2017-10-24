package com.ptit.pakandroidpractice.Lession04;

import android.util.Log;

/**
 * Created by bomng on 10/24/2017.
 */

public class Circle  extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    private final String TAG = getClass().getSimpleName();

    @Override
    public double calArea() {
        double res = radius*radius*3.14;
        Log.d(TAG, "calArea: "+ res);
        return res;
    }
}
