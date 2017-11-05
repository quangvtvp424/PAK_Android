package com.ptit.pakandroidpractice.lesson05;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.ptit.pakandroidpractice.R;

/**
 * Created by admin on 10/29/2017.
 */

public class lesson05Activity extends FragmentActivity implements IOnMenuItemClick {

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu_and_content);
/*
        FragmentManager fragmentManager = getSupportFragmentManager();
        //tra ve FragmentManager cua android.support.v4

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ContentFragment fragment = new ContentFragment();
        fragmentTransaction.add(R.id.content, fragment).commit();
*/
        fragmentManager = getSupportFragmentManager();
        menuFragment = (MenuFragment) fragmentManager.findFragmentById(R.id.fragment_left);
        contentFragment = (ContentFragment) fragmentManager.findFragmentById(R.id.fragment_right);
    }

    @Override
    public void onMenuItemClick(String id) {
        //Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        contentFragment.updateContent(id);
    }
}
