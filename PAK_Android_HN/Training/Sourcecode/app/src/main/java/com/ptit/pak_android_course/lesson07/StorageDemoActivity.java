package com.ptit.pak_android_course.lesson07;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Switch;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 11/25/2017.
 */

public class StorageDemoActivity extends Activity {

    private static final String PREF_SETTING = "preferences_setting";
    private static final String KEY_PREF_ROAMING = "key_fref_roaming";
    private static final String KEY_PREF_WIFI = "key_fref_wifi";

    Switch swRoaming;
    Switch swWifi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_demo_activity);
        swRoaming = (Switch) findViewById(R.id.sw_roaming);
        swWifi = (Switch) findViewById(R.id.sw_wifi);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveSetting();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreSetting();
    }

    private void saveSetting(){
        SharedPreferences preferences = this.getSharedPreferences(PREF_SETTING, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(KEY_PREF_ROAMING, swRoaming.isChecked()).apply();
        preferences.edit().putBoolean(KEY_PREF_WIFI, swWifi.isChecked()).apply();
    }

    private void restoreSetting(){
        SharedPreferences preferences = this.getSharedPreferences(PREF_SETTING, Context.MODE_PRIVATE);
        Boolean isRoaming = preferences.getBoolean(KEY_PREF_ROAMING, false);
        Boolean isWifiOn = preferences.getBoolean(KEY_PREF_WIFI, false);

        swRoaming.setChecked(isRoaming);
        swWifi.setChecked(isWifiOn);
    }
}
