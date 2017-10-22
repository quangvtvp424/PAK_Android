package com.ptit.pak_android_course.lesson04.day2;

/**
 * Created by quanglm on 10/22/17.
 */

public class SaleLand {


    public int getPriceSquare(Square square) {
        return square.calArea();
    }

    public int getPriceRect(Rectangle rectangle) {
        return rectangle.calArea();
    }

    public int getPrice(Shape shape) {
        return shape.calArea();
    }

    public int getPriceThruInterface(IGetAreaAble calAreaAble) {
        return calAreaAble.calArea1();
    }

}
