package com.ptit.pakandroidpractice.lesson5.ListFragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by AM on 11/4/2017.
 */

public class NewsTitleFragment extends ListFragment {
    public static final ArrayList<String> TITLE = new ArrayList<String>(){{
         add("Conte không màng MU, chỉ ngán MC ở NHA");
         add("ĐT Tây Ban Nha triệu tập, nhiều cựu cầu thủ của Liverpool xuất hiện");
         add("Barca sống nhờ nhịp Messi - Ter Stegen");
         add("Tottenham đối mặt với nguy cơ mất \"bộ não\" Pochettino");
    }};
    public static final ArrayList<String> TITLE_LINK = new ArrayList<String>() {{
        add("http://bongdaplus.vn/conte-khong-mang-m-u-chi-ngan-man-city-o-ngoai-hang-anh-2009211711.html");
        add("http://bongdaplus.vn/dt-tay-ban-nha-trieu-tap-nhieu-cuu-cau-thu-liverpool-xuat-hien-2009581711.html");
        add("http://bongdaplus.vn/barca-song-nho-nhip-dap-messi-ter-stegen-2009501711.html");
        add("http://bongdaplus.vn/tottenham-doi-mat-voi-nguy-co-mat-bo-nao-pochettino-2009391711.html");
    }};
    private boolean landMode;
}
