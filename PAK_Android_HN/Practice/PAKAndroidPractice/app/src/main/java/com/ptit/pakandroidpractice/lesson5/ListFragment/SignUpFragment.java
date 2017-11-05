package com.ptit.pakandroidpractice.lesson5.ListFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptit.pakandroidpractice.R;

/**
 * Created by AM on 11/5/2017.
 */

public class SignUpFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sign_up,container,false);
    }
}
