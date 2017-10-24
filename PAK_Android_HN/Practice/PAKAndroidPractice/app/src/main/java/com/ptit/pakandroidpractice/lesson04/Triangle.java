package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by Admin on 24/10/2017.
 */

public class Triangle extends Shape {

    protected int height;
    protected int bottom;

    public Triangle() {
    }

    public Triangle(int height, int bottom) {
        this.height = height;
        this.bottom = bottom;
    }

    @Override
    public double calArea() {
        return (double) this.height * this.bottom / 2;
    }
}
