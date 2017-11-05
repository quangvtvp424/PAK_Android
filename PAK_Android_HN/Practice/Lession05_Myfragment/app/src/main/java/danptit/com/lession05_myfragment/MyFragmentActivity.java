package danptit.com.lession05_myfragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

/**
 * Created by bomng on 10/29/2017.
 */

public class MyFragmentActivity  extends FragmentActivity implements OnMenuItemClick{


    private  MenuFragment menuFragment;
    private ContentFragment contentFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_with_menu);


       fragmentManager= getSupportFragmentManager();

        menuFragment = (MenuFragment) fragmentManager.findFragmentById(R.id.frag_left);
        contentFragment = (ContentFragment) fragmentManager.findFragmentById(R.id.frag_content1);
    }

    @Override
    public void OnMenuItemClick(String id) {

        contentFragment.updateContent(id);
    }
}
