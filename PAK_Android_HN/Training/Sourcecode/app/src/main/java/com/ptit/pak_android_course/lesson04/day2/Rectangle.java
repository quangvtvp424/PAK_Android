package com.ptit.pak_android_course.lesson04.day2;

import android.util.Log;

/**
 * Created by quanglm on 10/22/17.
 */

public class Rectangle extends Square {

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;

    }

    protected int height;

    @Override
    public int calArea() {
        int area = width*height;
        Log.d("SaleLand", getClass().getSimpleName() + " calArea: " + area);
        return area;
    }
}
