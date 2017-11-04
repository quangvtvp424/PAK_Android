package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 11/4/2017
 */

public class Circle extends CalArea {
    private double radius;
    Circle(double radius)
    {
        this.radius=radius;
    }
    public double calArea ()
    {
        return (3.14*radius*radius);
    }

}
