package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 10/22/2017.
 */

public class Circle extends Shape implements ICalArea {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (3.14*this.radius*this.radius);
    }

    @Override
    public double calArea() {
        return (3.14*this.radius*this.radius);
    }
}
