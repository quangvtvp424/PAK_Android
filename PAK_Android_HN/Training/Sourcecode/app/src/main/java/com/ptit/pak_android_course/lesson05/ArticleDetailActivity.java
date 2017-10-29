package com.ptit.pak_android_course.lesson05;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class ArticleDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.detail_activity);
        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            ArticleDetailFragment details = new ArticleDetailFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, details).commit();
        }
    }


}
