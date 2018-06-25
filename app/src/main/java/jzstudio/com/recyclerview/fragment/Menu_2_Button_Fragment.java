package jzstudio.com.recyclerview.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jzstudio.toolbar.recyclerview.R;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.Pages;
import jzstudio.com.recyclerview.adapter.MenuAdapter;
import jzstudio.com.recyclerview.interfaces.RecyclerViewClickListener;
import jzstudio.com.recyclerview.model.MyMenu;


/**
 * Created by icm_mobile on 2018/6/22.
 *
 * 此頁面由多個按鈕(TextView，非Button)排列成水平並佔滿屏幕構成。
 * 按鈕的數量參考至values/arrays.xml中的menuTitles數量
 */

public class Menu_2_Button_Fragment extends Fragment implements RecyclerViewClickListener {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    MyMenu myDataset;
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        Resources resources = context.getResources();
        /** menu頁面預設3顆按鈕，按鈕的標題及顏色可在xml裡更改 */
        myDataset = new MyMenu(resources.getStringArray(R.array.menu_2_button_Titles),resources.obtainTypedArray(R.array.menu_2_button_Ripples));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu,container,false);

        mRecyclerView =  v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false); //版面設置為橫向
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MenuAdapter(myDataset,(MainActivity) getContext(),this);
        mRecyclerView.setAdapter(mAdapter);

        /**action bar 標題更新*/
        MainActivity.Instance.updateToolbar(Pages.MENU_2_BUTTON);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //Offline,Online,Setup 三顆按鈕的響應
    @Override
    public void recyclerViewItemClicked(View v, int position) {
        Fragment des = null;
        switch(position) {
            case 0:
                des = new Directory_Sample_Fragment();
                break;
            case 1:
                des = new Directory_User_Library_Fragment();
                break;
        }

        Log.d("recyclerViewItemClicked","position - " + position+ " , " + ((TextView)v).getText() + "\r\n");

        if(des != null)
            MainActivity.Instance.switchFragment(this,des);


    }


}
