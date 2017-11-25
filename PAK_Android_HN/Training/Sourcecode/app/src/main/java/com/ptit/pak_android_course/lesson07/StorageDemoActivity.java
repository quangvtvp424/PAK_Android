package com.ptit.pak_android_course.lesson07;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.ptit.pak_android_course.R;
import com.ptit.pak_android_course.lesson07.room.AppDatabase;
import com.ptit.pak_android_course.lesson07.room.Student;
import com.ptit.pak_android_course.lesson07.room.StudentDAO;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

        AppDatabase app = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "pak-db").build();
        final StudentDAO dao = app.getStudentDao();

        final Student std1 = new Student("Duc Anh", "Hanoi", "IT");
        final Student std2 = new Student("Huong", "Saigon", "IT");
        final Student std3 = new Student("Hung", "Vinh Phuc", "IT");

        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertAll(std1, std2, std3);
            }
        }).start();

        Button btnCheck = (Button) findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Student> students = dao.getAll();
                        students.size();
                    }
                }).start();
            }
        });
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
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_PREF_ROAMING, swRoaming.isChecked());
        editor.putBoolean(KEY_PREF_WIFI, swWifi.isChecked());
        editor.apply();
    }

    private void restoreSetting(){
        SharedPreferences preferences = this.getSharedPreferences(PREF_SETTING, Context.MODE_PRIVATE);
        Boolean isRoaming = preferences.getBoolean(KEY_PREF_ROAMING, false);
        Boolean isWifiOn = preferences.getBoolean(KEY_PREF_WIFI, false);

        swRoaming.setChecked(isRoaming);
        swWifi.setChecked(isWifiOn);
    }

    private void saveFileToInternal(){
        File file = new File(getFilesDir(), "cache");
        String data = "text to save";
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(){
        File file = new File(getFilesDir(), "cache");
        FileInputStream fin;
        String temp="";
        try {
            fin = new FileInputStream(file);
            int c;
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            // error handling
        } catch (IOException e) {
            // error handling
        }

        return temp;
    }
}
