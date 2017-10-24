package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by Admin on 24/10/2017.
 */

public class Rectangle extends Square {
    protected int height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        super(width);
        this.height = height;
    }

    @Override
    public double calArea() {
        return this.width * this.height;
    }
}
