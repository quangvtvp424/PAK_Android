package com.ptit.pakandroidpractice.lesson4;

/**
 * Created by AM on 10/28/2017.
 */

public abstract class Shape {
    private String name;
    public abstract double area();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
