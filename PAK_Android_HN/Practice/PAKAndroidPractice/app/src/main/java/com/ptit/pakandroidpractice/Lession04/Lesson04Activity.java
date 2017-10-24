package com.ptit.pakandroidpractice.Lession04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;
import java.util.Random;

public class Lesson04Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int pick;
        ArrayList<Shape> arr = new ArrayList<>();
        Random rand = new Random();

        for (int j = 0; j < 100; j++) {
            pick = rand.nextInt(4);

            switch (pick) {
                case 0: {
                    arr.add(new Circle(rand.nextInt(50)));
                    break;

                }
                case 1: {
                    arr.add(new Rectangle(rand.nextInt(50), rand.nextInt(50)));
                    break;
                }
                case 2: {
                    arr.add(new Triangle(rand.nextInt(50), rand.nextInt(50)));
                    break;
                }
                case 3: {
                    arr.add(new Square(rand.nextInt(50)));
                    break;
                }
            }
        }
        for (Shape s : arr){
            s.calArea();
        }
    }
        
    }
