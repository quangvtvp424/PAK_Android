package com.ptit.pak_android_course.lesson05.dynamic.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class FragmentLayoutActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
    }


}
