package com.ptit.pak_android_course.lesson05.simplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.ptit.pak_android_course.R;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class ContentFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.content_fragment, container, false);
//        txtContent = (TextView)view.findViewById(R.id.txt_content);
        webView = new WebView(getActivity());
        return webView;
    }

    public void updateContent(String newContent){
        webView.loadUrl(newContent);
    }
}
