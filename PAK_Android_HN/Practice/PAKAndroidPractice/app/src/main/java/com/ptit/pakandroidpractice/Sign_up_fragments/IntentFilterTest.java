package com.ptit.pakandroidpractice.Sign_up_fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ptit.pakandroidpractice.R;

/**
 * Created by Admin on 10/4/2017.
 */

public class IntentFilterTest extends Activity {

    TextView tvHello;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.intent_filter_test_layout);

        tvHello = (TextView) findViewById(R.id.tvHello);

        Intent receiverIntent = getIntent();
        String username = receiverIntent.getStringExtra("username");
        StringBuilder str = new StringBuilder("Hello ");
        str.append(username);
        tvHello.setText(str.toString());
    }
}
