package com.ptit.pakandroidpractice.Sign_up_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.ptit.pakandroidpractice.R;

/**
 * Created by Tran Tuan Anh on 11/11/2017.
 */

public class FragmentManager extends FragmentActivity implements UpdateHello{

    SuccessfullySignUp_fragment successfullySignUpFragment = new SuccessfullySignUp_fragment();

    public static final String Preferences = "USERS";
    public static final String name = "username";
    public static final String email = "email";
    public static final String password = "password";

    public static SharedPreferences sharedPreferences;

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(Preferences, Context.MODE_PRIVATE);

        successfullySignUpFragment = (SuccessfullySignUp_fragment) getSupportFragmentManager().findFragmentById(R.id.success_fragment);

        if(sharedPreferences.getString(name, null) != null){

            String username = sharedPreferences.getString(name, null);
            updateSuccess(username);
        }
        else
            updateSuccess("");
    }

    @Override
    public void updateSuccess(String username) {
        successfullySignUpFragment.updateTextview(username);
    }
}
