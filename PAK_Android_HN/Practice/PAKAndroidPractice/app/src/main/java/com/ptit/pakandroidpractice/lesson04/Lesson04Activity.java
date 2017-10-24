package com.ptit.pakandroidpractice.lesson04;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 24/10/2017.
 */

public class Lesson04Activity extends Activity {

    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Shape> listShape = new ArrayList<Shape>();
        creat(listShape);
        printArea(listShape);
    }

    private void creat(ArrayList<Shape> listShape) {
        Random rand = new Random();
        int n;
        for (int i = 0; i < 100; i++) {
            n = rand.nextInt(4);
            switch (n) {
                case 0:
                    listShape.add(new Square(rand.nextInt(100)));
                    break;
                case 1:
                    listShape.add(new Rectangle(rand.nextInt(100), rand.nextInt(100)));
                    break;
                case 2:
                    listShape.add(new Triangle(rand.nextInt(100), rand.nextInt(100)));
                    break;
                case 3:
                    listShape.add(new Circle(rand.nextInt(100)));
                    break;
                default:
                    break;
            }
        }
    }

    private void printArea(ArrayList<Shape> listShape) {
        for (Shape shape : listShape) {
            Log.d(TAG, shape.getClass().getName() + ": " + shape.calArea());
        }
    }
}
