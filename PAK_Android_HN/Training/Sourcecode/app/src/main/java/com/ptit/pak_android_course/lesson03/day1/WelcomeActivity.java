package com.ptit.pak_android_course.lesson03.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ptit.pak_android_course.R;

/**
 * Created by quanglm on 9/30/17.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent i = getIntent();
        if (i != null) {
            String userName = i.getExtras().getString("username");
            ((TextView) findViewById(R.id.textView)).setText(userName);
            ((EditText) findViewById(R.id.editText)).setText(userName);
            String textExtra = i.getExtras().getString(android.content.Intent.EXTRA_TEXT);
            if (!TextUtils.isEmpty(textExtra)) {
                ((TextView) findViewById(R.id.textView)).setText(textExtra);
            }
        } else {
            ((TextView)findViewById(R.id.textView)).setText("Have Nothing!");
        }
    }

    public void showDialog(View view) {

//        new AlertDialog.Builder(this)
//                .setMessage("Testing activity lifecycle!")
//                .setPositiveButton("OK", null)
//
//                .show();

        Intent i = new Intent(this, DialogActivity.class);
        startActivity(i);
    }
}
