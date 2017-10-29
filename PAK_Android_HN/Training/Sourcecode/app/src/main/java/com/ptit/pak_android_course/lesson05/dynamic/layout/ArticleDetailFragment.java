package com.ptit.pak_android_course.lesson05.dynamic.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class ArticleDetailFragment extends Fragment {

    public static final String KEY_INDEX = "index";

    public static ArticleDetailFragment newInstance(int currentPosition) {

        Bundle args = new Bundle();
        args.putInt(KEY_INDEX, currentPosition);
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public int getArticleIndex(){
        return getArguments().getInt(KEY_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WebView webview = new WebView(getActivity());
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(NewsTitleFragment.URL.get(getArticleIndex()));
        return webview;
    }
}
