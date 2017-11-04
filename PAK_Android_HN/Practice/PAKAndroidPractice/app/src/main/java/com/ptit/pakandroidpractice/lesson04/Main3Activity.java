package com.ptit.pakandroidpractice.lesson04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;
import java.util.Random;

public class Main3Activity extends AppCompatActivity {
    final String TAG=getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ArrayList<CalArea> shapeList=new ArrayList<>();
        addObject(shapeList);
        printObject(shapeList);



    }
    void addObject (ArrayList<CalArea> shapeList)
    {
        Random random =new Random();
        int m;
        for(int i=0; i<100;i++)
        {
            m=random.nextInt(4);
            switch (m) {
                case 0:
                    shapeList.add(new Square(random.nextInt(100)));
                    break;

                case 1:
                    shapeList.add(new Circle(random.nextInt(100)));
                    break;

                case 2:
                    shapeList.add(new Rectangle(random.nextInt(100),random.nextInt(100)));
                    break;
                case 3:
                    shapeList.add(new Triangle(random.nextInt(100),random.nextInt(100)));
                    break;
            }

        }
    }
    void printObject(ArrayList<CalArea> shapeList)
    {
        for(CalArea shape : shapeList)
        {
            Log.d(TAG,"Area is:"+shape.calArea());
        }
    }
}
