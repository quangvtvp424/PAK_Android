package com.ptit.pakandroidpractice.Sign_up_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ptit.pakandroidpractice.R;

/**
 * Created by Admin on 11/5/2017.
 */


    public class MainActivity extends BaseActivity {

        Button btnSign;
        CheckBox cbCheck;

        EditText etUsername;
        EditText etEmail;
        EditText etPassword;

        public static final String Preferences = "USERS";
        public static final String name = "username";
        public static final String email = "email";
        public static final String password = "password";

        SharedPreferences sharedPreferences;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up_fragments_layout);


            btnSign = (Button) findViewById(R.id.btnSignup);
            cbCheck = (CheckBox) findViewById(R.id.cbCheck);
            etUsername = (EditText) findViewById(R.id.etUsername);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etPassword = (EditText) findViewById(R.id.etPassword);

            sharedPreferences = getSharedPreferences(Preferences, Context.MODE_PRIVATE);

            if(sharedPreferences.getString(name, null) != null){
                Intent intent = new Intent(getBaseContext(), IntentFilterTest.class);
                String username = sharedPreferences.getString(name, null);
                intent.putExtra(name, username);
                startActivity(intent);
            }


            btnSign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), IntentFilterTest.class);
                    String username = etUsername.getText().toString();
                    intent.putExtra(name, username);
                    //push vao Preferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(name, username);
                    editor.putString(email, etEmail.getText().toString());
                    editor.putString(password, etPassword.getText().toString());
                    editor.apply();

                    startActivity(intent);
                }
            });

            cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(cbCheck.isChecked()){
                        Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }
    }

