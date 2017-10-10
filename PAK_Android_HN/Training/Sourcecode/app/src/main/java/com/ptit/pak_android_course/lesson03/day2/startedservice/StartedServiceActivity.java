package com.ptit.pak_android_course.lesson03.day2.startedservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/9/2017.
 */

public class StartedServiceActivity extends Activity implements View.OnClickListener {

    private Button mBtnStartService;
    private Button mBtnStartServiceNewThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.started_service_activity);
        mBtnStartService = (Button)findViewById(R.id.btn_start_service);
        mBtnStartService.setOnClickListener(this);
        mBtnStartServiceNewThread = (Button)findViewById(R.id.btn_download_img);
        mBtnStartServiceNewThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_service:
                startService();
                break;
            case R.id.btn_download_img:
                startServiceAndDoingHeavyThings();
                break;
        }
    }

    private void startService(){
        startService(new Intent(this, StartedServiceBasic.class));
    }

    private void startServiceAndDoingHeavyThings(){
        startService(new Intent(this, StartedServiceCreatingNewThread.class));
    }
}
