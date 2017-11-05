package danptit.com.lession05_myfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bomng on 10/29/2017.
 */

public class MenuFragment  extends Fragment implements View.OnClickListener {

    private OnMenuItemClick mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener= (OnMenuItemClick) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener= null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        view.findViewById(R.id.btn_1).setOnClickListener(this);
        view.findViewById(R.id.btn_2).setOnClickListener(this);
       return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_1 :
               mListener.OnMenuItemClick("btn 1  is clicked");
               break;

           case R.id.btn_2:
               mListener.OnMenuItemClick("http://www.24h.com.vn/tin-tuc-trong-ngay/vo-de-o-chuong-my-ha-noi-la-vo-co-ke-hoach-c46a910371.html");
               break;

           default:
       }
    }
}
