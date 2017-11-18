package com.ptit.pak_android_course.lesson05.simplefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class MenuFragment extends Fragment implements View.OnClickListener{

    private OnMenuItemClick mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnMenuItemClick) context;
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
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                mListener.onMenuItemClick("btn 1 is clicked");
                break;
            case R.id.btn2:
                mListener.onMenuItemClick("https://developer.android.com/guide/components/fragments.html#Lifecycle");
                break;
            default:
        }
    }


}
