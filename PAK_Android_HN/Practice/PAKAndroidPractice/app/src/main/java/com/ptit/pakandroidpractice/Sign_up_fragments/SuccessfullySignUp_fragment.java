package com.ptit.pakandroidpractice.Sign_up_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ptit.pakandroidpractice.R;

/**
 * Created by Admin on 10/4/2017.
 */

public class SuccessfullySignUp_fragment extends Fragment {

    TextView tvHello;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.successfully_sign_up_fragment, container, false);
        tvHello = (TextView) view.findViewById(R.id.tvHello);
        return view;
    }


    public void updateTextview(String username) {
        tvHello.setText("Hello " + username);
    }
}
