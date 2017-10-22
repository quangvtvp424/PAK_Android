package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 10/22/2017.
 */

public class Triangle extends Shape implements ICalArea {

    private double bottom, height;

    public Triangle(double bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (this.bottom*this.height)/2;
    }

    @Override
    public double calArea() {
        return (this.bottom*this.height)/2;
    }
}
