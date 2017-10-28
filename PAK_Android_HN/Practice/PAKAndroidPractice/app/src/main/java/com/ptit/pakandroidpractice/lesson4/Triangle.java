package com.ptit.pakandroidpractice.lesson4;

/**
 * Created by AM on 10/28/2017.
 */

public class Triangle extends Shape {
    private double length1,length2,length3;

    public Triangle() {
    }

    public Triangle(double length1, double length2, double length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
        super.setName("Triangle");

    }

    @Override
    public double area() {
        double s = (length1+length2+length3)/2;
        return Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
    }
}
