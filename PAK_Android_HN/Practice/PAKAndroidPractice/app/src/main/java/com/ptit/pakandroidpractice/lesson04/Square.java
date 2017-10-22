package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 10/22/2017.
 */

public class Square extends Shape implements ICalArea {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double calArea() {
        return (this.edge * this.edge);
    }

    @Override
    public double calculateArea() {
        return (this.edge * this.edge);
    }
}
