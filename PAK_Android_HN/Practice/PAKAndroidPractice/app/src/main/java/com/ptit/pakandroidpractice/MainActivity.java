package com.ptit.pakandroidpractice;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ptit.pakandroidpractice.lesson4.Circle;
import com.ptit.pakandroidpractice.lesson4.Rectangle;
import com.ptit.pakandroidpractice.lesson4.Shape;
import com.ptit.pakandroidpractice.lesson4.Square;
import com.ptit.pakandroidpractice.lesson4.Triangle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final private int NUMBER_OF_SHAPE=100;
    final private int MAX_RANGE_DATA_RANDOM = 10;
    private ArrayList<Shape> listOfShape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfShape = new ArrayList<>();
        initDumpData();
        showArea();
    }

    private void initDumpData() {
        Random radType,radData;
        int type;
        radType = new Random();
        radData     = new Random();
        for (int i=0;i<NUMBER_OF_SHAPE;i++) {
            type = radType.nextInt(4);
            switch (type) {
                case 0:
                    Square    square = new Square(radData.nextInt(MAX_RANGE_DATA_RANDOM)+1);
                    listOfShape.add(square);
                    break;
                case 1:
                    Rectangle rectangle = new Rectangle(radData.nextInt(MAX_RANGE_DATA_RANDOM)+1,
                                                        radData.nextInt(MAX_RANGE_DATA_RANDOM)+1
                                                        );
                    listOfShape.add(rectangle);
                    break;
                case 2:
                    Triangle  triangle = new Triangle(radData.nextInt(MAX_RANGE_DATA_RANDOM)+1,
                                                      radData.nextInt(MAX_RANGE_DATA_RANDOM)+1,
                                                      radData.nextInt(MAX_RANGE_DATA_RANDOM)+1
                                                     );
                    listOfShape.add(triangle);
                    break;
                case 3:
                    Circle    circle = new Circle(radData.nextInt(MAX_RANGE_DATA_RANDOM)+1);
                    listOfShape.add(circle);
                    break;
            }
        }
    }
    public void showArea() {
        for (int i=0;i<NUMBER_OF_SHAPE;i++) {
            Log.i("DIENTICH:", listOfShape.get(i).getName()+
                                     ":   "+
                                     String.valueOf(listOfShape.get(i).area()));
        }
    }

    /**
     * Created by AM on 11/5/2017.
     */

    public static class SignUpActivity extends FragmentActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up_main);
        }
    }
}
