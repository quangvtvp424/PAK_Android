package com.ptit.pakandroidpractice.Sign_up_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ptit.pakandroidpractice.R;

/**
 * Created by Admin on 11/5/2017.
 */


public class SignUp_fragment extends Fragment{

    Button btnSign;
    CheckBox cbCheck;

    EditText etUsername;
    EditText etEmail;
    EditText etPassword;

    UpdateHello update;

    //gan update voi activity(context) de xu ly trung gian giua cac fragments
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        update = (UpdateHello) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        update = null;
    }

    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.sign_up_fragments_layout, container, false);
            btnSign = (Button) view.findViewById(R.id.btnSignup);
            cbCheck = (CheckBox) view.findViewById(R.id.cbCheck);
            etUsername = (EditText) view.findViewById(R.id.etUsername);
            etEmail = (EditText) view.findViewById(R.id.etEmail);
            etPassword = (EditText) view.findViewById(R.id.etPassword);

            btnSign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    //                Intent intent = new Intent(getContext(), SuccessfullySignUp_fragment.class);
                    String username = etUsername.getText().toString();
    //                intent.putExtra("username", username);
                    //push vao Preferences
                    SharedPreferences.Editor editor = FragmentManager.sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("email", etEmail.getText().toString());
                    editor.putString("password", etPassword.getText().toString());
                    editor.apply();

                    Log.d("test", "onClick: sharePref : " + username);
    //                    startActivity(intent);
                    update.updateSuccess(username);
                    Log.d("test", "onClick: update");
                }
            });

            return view;
        }


}

