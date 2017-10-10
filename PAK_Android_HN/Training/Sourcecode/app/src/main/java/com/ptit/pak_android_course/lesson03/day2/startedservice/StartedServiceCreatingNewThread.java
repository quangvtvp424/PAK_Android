package com.ptit.pak_android_course.lesson03.day2.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Thuannd on 10/9/2017.
 * Let say this service will do heavy thing such as downloading, decoding image
 * therefore we have to create new separated thread in order to ovoid blocking of main thread
 */

public class StartedServiceCreatingNewThread extends Service {

    private Looper mLooper;
    private MyHandler mMyHandler;

    // Handler that receives messages from the thread
    private final class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            // this like we do heavy work such as image processing
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
            // Stop myService after finishing our work
            Toast.makeText(StartedServiceCreatingNewThread.this, "its done, then stop it self", Toast.LENGTH_SHORT).show();
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // create new thread to use for heavy jobs
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mLooper = thread.getLooper();
        mMyHandler = new MyHandler(mLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "service performing heavy thing...", Toast.LENGTH_SHORT).show();
        // send message to our separated thread to perform
        Message msg = mMyHandler.obtainMessage();
        msg.arg1 = startId;
        mMyHandler.sendMessage(msg);

        // START_STICKY indecate that our service will be restarted if it get killed
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
