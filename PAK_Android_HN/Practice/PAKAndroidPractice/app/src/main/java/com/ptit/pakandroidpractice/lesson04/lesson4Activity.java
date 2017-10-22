package com.ptit.pakandroidpractice.lesson04;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by admin on 10/22/2017.
 */

public class lesson4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ICalArea> shapeList = new ArrayList<>();
        createDummy(shapeList);
        printEachShapeArea(shapeList);
    }

    private void createDummy(ArrayList<ICalArea> shapeList) {
        Random rand = new Random();
        int n;
        for (int i = 0; i < 100; i++) {
            n = rand.nextInt(4);
            switch (n) {
                case 0:
                    shapeList.add(new Square(rand.nextInt(100)));
                    break;
                case 1:
                    shapeList.add(new Rectangle(rand.nextInt(100), rand.nextInt(100)));
                    break;
                case 2:
                    shapeList.add(new Triangle(rand.nextInt(100), rand.nextInt(100)));
                    break;
                case 3:
                    shapeList.add(new Circle(rand.nextInt(100)));
                    break;
                default:
                    break;
            }
        }
    }

    private void printEachShapeArea(ArrayList<ICalArea> shapeList) {
        final String TAG = getClass().getSimpleName();
        for (ICalArea shape: shapeList) {
            Log.d(TAG, "printEachShapeArea: " + shape.calculateArea());
        }
    }
}
