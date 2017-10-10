package com.ptit.pak_android_course.lesson03.day2.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Thuannd on 10/9/2017.
 */

public class BoundService extends Service{

    private MyBinder mBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void downloadImg(String url){
        // take url as param then create new thread to download
        Toast.makeText(this, "BoundService doing something here...", Toast.LENGTH_SHORT).show();
    }

    public class MyBinder extends Binder {
        public BoundService getService(){
            return BoundService.this;
        }
    }
}
