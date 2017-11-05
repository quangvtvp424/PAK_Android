package com.ptit.pakandroidpractice.lesson05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ptit.pakandroidpractice.R;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp;
    EditText user;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        user = (EditText) findViewById(R.id.user);

        sharedPreferences = getSharedPreferences("dataUser", MODE_PRIVATE);
        if(!sharedPreferences.getString("username","").equals("")){
            nextPageWithout();
        }
        btnSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                xulyClick();
            }
        });
    }


    private void nextPageWithout() {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("username", sharedPreferences.getString("username", ""));
        startActivity(intent);
    }

    public void xulyClick()
    {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra("username",user.getText().toString());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", user.getText().toString() );
        editor.apply();
        startActivity(i);
    }
}
