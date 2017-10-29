package com.ptit.pak_android_course.lesson05.simplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class MyFragmentActivity extends FragmentActivity implements OnMenuItemClick{

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_with_menu);

        fragmentManager = getSupportFragmentManager();

        menuFragment = (MenuFragment) fragmentManager.findFragmentById(R.id.frag_left);
        contentFragment = (ContentFragment) fragmentManager.findFragmentById(R.id.frag_content);

    }

    @Override
    public void onMenuItemClick(String id) {
        contentFragment.updateContent(id);
    }
}
