package com.ptit.pakandroidpractice.lesson05;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ptit.pakandroidpractice.R;

/**
 * Created by admin on 11/5/2017.
 */

public class SignupFragment extends Fragment {

    EditText edtUsername;
    Button btnSignUp;

    IOnSignupClick transferByClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        btnSignUp = (Button) view.findViewById(R.id.btnSignUp);

        transferByClick = (IOnSignupClick) getActivity();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferByClick.transferData(edtUsername.getText().toString().trim());
            }
        });
        return view;
    }
}
