package jzstudio.com.recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import jzstudio.com.recyclerview.fragment.Menu_3_Button_Fragment;

public class MainActivity extends AppCompatActivity {

    public static MainActivity Instance;
//    DrawerLayout mDrawerLayout;
    Toolbar toolbar;

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }

    public void updateToolbar(String page) {
        int title = -1;

        switch (page) {
            case Pages.MENU_3_BUTTON:
                title = R.string.title_menu_3_button;
                break;
            case Pages.MENU_2_BUTTON:
                title = R.string.title_menu_2_button;
                break;
            case Pages.DIRECTORY_KXF:
                title = R.string.title_directory_kxf;
                break;
            case Pages.DIRECTORY_SAMPLE:
                title = R.string.title_directory_sample;
                break;
            case Pages.DIRECTORY_USER_LIBRARY:
                title = R.string.title_directory_user_library;
                break;

            default:
                title = R.string.app_name;
                break;
        }
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Instance = this;

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);


//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.icon_hamburger);

//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                item.setChecked(true);
//                mDrawerLayout.closeDrawer(Gravity.LEFT);
//                return true;
//            }
//        });



        switchFragment(new Menu_3_Button_Fragment());
    }

    public List<String> getDirectory_Names_KXF() {
        List<String> data = new ArrayList<>();
        if(data.size() <= 0) {
            data.add("\'09~\'11 KX450F");
            data.add("\'11~\'12 KX250F");
            data.add("\'12 KX450F");
            data.add("\'13 KX250F");
            data.add("\'13~\'15 KX450F");
            data.add("\'14 KX250F");
            data.add("\'16 KX450F");
            data.add("aaaaa");
            data.add("aaaaa");
            data.add("aaaaa");
            data.add("aaaaa");
        }
        return data;
    }

    public List<String> getDirectory_Names_Sample() {
        List<String> data = new ArrayList<>();
        if(data.size() <= 0) {
            data.add("Advanced Ignition Setting");
            data.add("Beginner");
            data.add("Hard Riding Surface");
            data.add("Leaner Fuel Setting");
            data.add("Retarded Ignition Setting");
            data.add("Richer Fuel Setting");
            data.add("Soft Riding Surface");
        }
        return data;
    }

    public List<String> getDirectory_Names_User_Library() {
        List<String> data = new ArrayList<>();
        if(data.size() <= 0) {
            data.add("Default");
        }
        return data;
    }

    public void switchFragment(Fragment destFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(!destFragment.isAdded())
            fragmentTransaction.add(R.id.fragment_container,destFragment);
//        else
//            fragmentTransaction.replace(R.id.fragment_container,destFragment);
        fragmentTransaction.commit();
    }

    boolean needToAddBackStack = true;
    boolean needAnimation = true;

    public void switchFragment(Fragment from , Fragment to) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(needAnimation)
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out); //必須用自定義動畫才有效果，原因https://www.e-learn.cn/content/wangluowenzhang/89903
        if(from.isAdded())
            fragmentTransaction.replace(R.id.fragment_container,to);
        //將當前fragment加入stack，讓下一個頁面可退回上一頁。若沒加，則當前fragment會被銷毀。
        if(needToAddBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
