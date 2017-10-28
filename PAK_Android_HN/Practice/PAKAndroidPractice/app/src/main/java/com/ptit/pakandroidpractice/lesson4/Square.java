package com.ptit.pakandroidpractice.lesson4;

/**
 * Created by AM on 10/28/2017.
 */

public class Square extends Shape {
    private double length;

    public Square() {
    }

    public Square(double length) {
        super.setName("Square");
        this.length = length;
    }

    @Override
    public double area() {
        return length*length;
    }
}
