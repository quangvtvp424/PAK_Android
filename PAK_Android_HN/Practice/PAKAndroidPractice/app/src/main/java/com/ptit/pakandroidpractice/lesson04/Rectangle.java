package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 11/4/2017
 */

public class Rectangle extends CalArea {
    private double height;
    private double width;
    Rectangle(double height,double width)
    {
        this.height=height;
        this.width=width;
    }
    public double calArea()
    {
       return (height * width);
    }
}
