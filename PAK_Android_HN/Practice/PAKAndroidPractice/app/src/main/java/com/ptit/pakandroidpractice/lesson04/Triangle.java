package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 11/4/2017
 */

public class Triangle extends CalArea {
    private double bottom, height;
    Triangle( double bottom ,double height)
    {
        this.bottom=bottom;
        this.height=height;
    }
    public double calArea()
    {
        return (bottom*height)/2;
    }
}
