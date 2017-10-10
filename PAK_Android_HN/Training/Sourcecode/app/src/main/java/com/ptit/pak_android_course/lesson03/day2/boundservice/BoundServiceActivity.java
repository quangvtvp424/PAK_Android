package com.ptit.pak_android_course.lesson03.day2.boundservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/9/2017.
 */

public class BoundServiceActivity extends Activity{

    private TextView mTxtDes;
    private Button mBtnDownload;
    private BoundService mService;
    private Boolean mBound = false;

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((BoundService.MyBinder)service).getService();
            mTxtDes.setText("Already bound to service now we had connection");
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_service_activity);
        mTxtDes = (TextView) findViewById(R.id.txt_des);
        mBtnDownload = (Button) findViewById(R.id.btn_download);
        mBtnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound){
                    mService.downloadImg("http://mp3.zing....");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBound){
            unbindService(mServiceConnection);
            mBound = false;
        }
    }
}
