package com.ptit.pakandroidpractice.practicefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ptit.pakandroidpractice.R;

/**
 * Created by AM on 11/5/2017.
 */

public class SignUpActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }
}
