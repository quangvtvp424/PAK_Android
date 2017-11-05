package com.ptit.pakandroidpractice.lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ptit.pakandroidpractice.R;

public class Main2Activity extends AppCompatActivity {
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
    }

    private void addControls() {
        Intent intent = getIntent();
        txtKQ = (TextView) findViewById(R.id.txtKQ);
        String username = intent.getStringExtra("username");
        txtKQ.setText("Hello "+username);
    }
}
