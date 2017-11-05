package com.ptit.pakandroidpractice.lesson05;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptit.pakandroidpractice.R;

/**
 * Created by admin on 10/29/2017.
 */

public class MenuFragment extends Fragment implements View.OnClickListener {

    private IOnMenuItemClick mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (IOnMenuItemClick) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mListener.onMenuItemClick("Button 1 is clicked!");
                break;
            case R.id.button2:
                mListener.onMenuItemClick("https://www.google.com/");
                break;
            default:
        }
    }
}
