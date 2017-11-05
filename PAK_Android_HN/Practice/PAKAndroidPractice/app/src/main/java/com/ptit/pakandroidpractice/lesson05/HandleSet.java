package com.ptit.pakandroidpractice.lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ptit.pakandroidpractice.R;

public class HandleSet extends AppCompatActivity {

    TextView txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_set);

        txtSend = (TextView) findViewById(R.id.txtSend);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                handleSendText(intent);
            }
        }
    }

    private void handleSendText (Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if( sharedText != null){
            txtSend.setText(sharedText);
        }
    }
}
