package com.ptit.pakandroidpractice.lesson05;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ptit.pakandroidpractice.R;

/**
 * Created by admin on 10/29/2017.
 */

public class lesson05Activity extends AppCompatActivity implements IOnSignupClick {

    private FragmentManager fragmentManager;

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        sharedPreferences = getSharedPreferences("dataSignup", MODE_PRIVATE);
        initializingFragment();
    }

    private void initializingFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //if username value isn't existed, then load the SignupFragment, else load the WelcomeFragment
        if (sharedPreferences.getString("username", "").equals("")) {
            fragmentTransaction.add(R.id.frameContent, new SignupFragment(), "signup");
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.add(R.id.frameContent, new WelcomeFragment(), "welcome");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void transferData(String stringData) {
        if (sharedPreferences.getString("username", "").equals("")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", stringData);
            editor.commit();
        } else {
            //do nothing
        }
        FragmentTransaction fragTrans = fragmentManager.beginTransaction();
        fragTrans.replace(R.id.frameContent, new WelcomeFragment());
        fragTrans.commit();
    }
}
