package com.ptit.pakandroidpractice.lesson4;

/**
 * Created by AM on 10/28/2017.
 */

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        super.setName("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
