package com.ptit.pakandroidpractice.lesson4;

/**
 * Created by AM on 10/28/2017.
 */

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        super.setName("Rectangle");
    }

    @Override
    public double area() {
        return length*width;
    }
}
