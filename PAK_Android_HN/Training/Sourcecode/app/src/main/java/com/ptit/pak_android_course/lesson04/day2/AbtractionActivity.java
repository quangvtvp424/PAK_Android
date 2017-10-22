package com.ptit.pak_android_course.lesson04.day2;

import android.app.Activity;
import android.os.Bundle;

import com.ptit.pak_android_course.R;

import java.util.ArrayList;

public class AbtractionActivity extends Activity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Square square = new Square(100);
        Rectangle rectangle = new Rectangle(30,40);

        SaleLand saleLand = new SaleLand();
//        saleLand.getPriceSquare(square);
//        saleLand.getPriceRect(rectangle);

        saleLand.getPrice(square);
        saleLand.getPrice(rectangle);


        saleLand.getPriceThruInterface(square);
        saleLand.getPriceThruInterface(rectangle);

    }

    public ArrayList<Account> getListData() {
        Account account;
        ArrayList<Account> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            account = new Account();
            arrayList.add(account);
        }
        return arrayList;
    }


    class Account {
        String name;
    }



}
