package com.ptit.pak_android_course.lesson04.day2;

import android.util.Log;

/**
 * Created by quanglm on 10/22/17.
 */

public class Square extends Shape implements IGetAreaAble {

    public Square() {}

    public Square(int width) {
        this.width = width;
    }

    protected int width;

    public int calArea() {
        int area = width*width;
        Log.d("SaleLand", getClass().getSimpleName() + " calArea: " + area);
        return area;
    }

    @Override
    public int calArea1() {
        return calArea();
    }
}
