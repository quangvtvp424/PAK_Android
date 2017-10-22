package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 10/22/2017.
 */

public class SaleLand {

    public double getPrice(Shape shape) {
        return shape.calArea();
    }

    public double getPriceThroughICalArea(ICalArea calAreaAble) {
        return calAreaAble.calculateArea();
    }
}
