package com.ptit.pakandroidpractice.lesson05;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ptit.pakandroidpractice.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by admin on 11/5/2017.
 */

public class WelcomeFragment extends Fragment {

    public SharedPreferences sharedPreferences;

    TextView txvUsername;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        txvUsername = (TextView) view.findViewById(R.id.txvUsername);

        sharedPreferences = getActivity().getSharedPreferences("dataSignup", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        txvUsername.setText(username);

        return view;
    }
}
