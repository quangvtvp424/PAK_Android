package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 10/22/2017.
 */

public class Rectangle extends Shape implements ICalArea {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calArea() {
        return (this.height * this.width);
    }

    @Override
    public double calculateArea() {
        return (this.height * this.width);
    }
}
