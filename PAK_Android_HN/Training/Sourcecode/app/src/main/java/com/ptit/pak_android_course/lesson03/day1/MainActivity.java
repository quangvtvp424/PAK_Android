package com.ptit.pak_android_course.lesson03.day1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ptit.pak_android_course.R;

import java.util.List;

public class MainActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void intentAction(View view) {
//        intentDialNumber();
        showActionSend();
    }

    private void intentDialNumber() {
        Uri number = Uri.parse("tel:0914471189");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
//        testQueryIntent(callIntent);
        startActivity(callIntent);


    }

    private void showActionSend() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "my app"));
    }

    private void testQueryIntent(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        Log.d(TAG, "testQueryIntent: isIntentSafe = " + isIntentSafe);
        if (isIntentSafe) {
            for (ResolveInfo info : activities)
            Log.d(TAG, "testQueryIntent: activities matched: " + info.activityInfo.name);
        }

    }

    public void openWelcomeScreen(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", "Admin");
        startActivity(intent);
    }



}
