package com.ptit.pakandroidpractice.lesson04;

/**
 * Created by admin on 11/4/2017
 */

public class Square extends CalArea {
    private double edge;
    Square(double edge)
    {
        this.edge = edge;
    }

    public double calArea()
    {
        return edge*edge;
    }

}
