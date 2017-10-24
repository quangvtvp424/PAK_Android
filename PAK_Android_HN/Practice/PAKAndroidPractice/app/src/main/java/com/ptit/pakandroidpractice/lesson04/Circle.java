package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by Admin on 24/10/2017.
 */

public class Circle extends Shape {

    protected int radius;

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calArea() {
        return Math.PI * this.radius * this.radius / 2;
    }
}
