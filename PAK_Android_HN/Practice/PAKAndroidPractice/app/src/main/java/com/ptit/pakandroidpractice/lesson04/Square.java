package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by Admin on 24/10/2017.
 */

public class Square extends Shape {

    protected int width;

    public Square() {

    }

    public Square(int width) {
        this.width = width;
    }

    @Override
    public double calArea() {
        return this.width * this.width;
    }
}
