package com.ptit.pak_android_course.lesson03.day2.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Thuannd on 10/9/2017.
 */

public class StartedServiceBasic extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "StartedServiceBasic onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "StartedServiceBasic perform request to do something...", Toast.LENGTH_SHORT).show();
        // shudown by itself
        Toast.makeText(this, "Its done now then service stop by it self", Toast.LENGTH_SHORT).show();
        stopSelf(startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "StartedServiceBasic onDestroy", Toast.LENGTH_SHORT).show();
    }
}
