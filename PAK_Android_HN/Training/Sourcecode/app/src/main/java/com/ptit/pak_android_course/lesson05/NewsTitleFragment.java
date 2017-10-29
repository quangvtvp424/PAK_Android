package com.ptit.pak_android_course.lesson05;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ptit.pak_android_course.R;

import java.util.ArrayList;

/**
 * Created by Thuannd on 10/29/2017.
 */

public class NewsTitleFragment extends ListFragment {

    public static final ArrayList<String> TITLES = new ArrayList<String>() {{
        add("Anh đại thắng Tây Ban Nha, vô địch U17 World Cup");
        add("Thủ tướng vào bếp ăn cơm cùng công nhân Đồng Nai");
        add("Arsenal thắng ngược trận thứ 800 của Wenger ở Ngoại hạng Anh");
    }};

    public static final ArrayList<String> URL = new ArrayList<String>() {{
        add("https://thethao.vnexpress.net/tin-tuc/cac-giai-khac/anh-dai-thang-tay-ban-nha-vo-dich-u17-world-cup-3662437.html");
        add("https://vnexpress.net/tin-tuc/thoi-su/thu-tuong-vao-bep-an-com-cung-cong-nhan-dong-nai-3662359.html");
        add("https://thethao.vnexpress.net/tin-tuc/giai-ngoai-hang-anh/arsenal-thang-nguoc-tran-thu-800-cua-wenger-o-ngoai-hang-anh-3662407.html");
    }};

    public static final String KEY_CURRENT_ARTICLE = "current_choice";

    boolean landMode;
    int mCurrentPosition = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, TITLES));

        View detailFragment = getActivity().findViewById(R.id.fragment_detail);
        landMode = detailFragment != null && detailFragment.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(KEY_CURRENT_ARTICLE);
        }

        if (landMode) {
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            showDetail(mCurrentPosition);
        }
    }

    private void showDetail(int currentArticleIndex) {
        if (landMode) {
            getListView().setItemChecked(currentArticleIndex, true);
            ArticleDetailFragment details = ArticleDetailFragment.newInstance(currentArticleIndex);

            // Execute a transaction, replacing any existing fragment
            // with this one inside the frame.
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_detail, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
//        }

//        if (getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_detail) != null) {
//            ArticleDetailFragment details = (ArticleDetailFragment)
//                    getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_detail);
//
//                details = ArticleDetailFragment.newInstance(currentArticleIndex);
//
//                // Execute a transaction, replacing any existing fragment
//                // with this one inside the frame.
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.fragment_detail, details);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), ArticleDetailActivity.class);
            intent.putExtra(ArticleDetailFragment.KEY_INDEX, currentArticleIndex);
            startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_ARTICLE, mCurrentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetail(position);
    }
}
