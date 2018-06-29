package jzstudio.com.recyclerview.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.Pages;
import jzstudio.com.recyclerview.adapter.MapAdjustmentAdapter;
import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;
import jzstudio.com.recyclerview.model.Menu;

/**
 * Created by icm_mobile on 2018/6/27.
 */

public class Map_Adjustment_Fragment extends Fragment implements IRecyclerViewClickListener{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context context;

    List<Menu> mData = new ArrayList<>();

    @SuppressLint("ResourceType")
    public void initModel() {
        /** menu頁面預設3顆按鈕，按鈕的標題及顏色可在xml裡更改 */
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.map_adjustment);
        TypedArray backgrounds = resources.obtainTypedArray(R.array.map_adjustment_Ripples);

        for(int i = 0; i < titles.length; i++) {
            mData.add(new Menu( titles[i] , backgrounds.getDrawable(i)));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        initModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map_adjustment,container,false);

        mRecyclerView =  v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false); //版面設置為橫向
        mLayoutManager = new GridLayoutManager(context,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MapAdjustmentAdapter(mData,(MainActivity) getContext(),this);
        mRecyclerView.setAdapter(mAdapter);

        /** action bar 標題更新 */
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


    @Override
    public void recyclerViewItemClicked(View v, int position) {
        Fragment des = null;
        switch (position) {
            case 0 :
                des = new Table_Offline_Edit_Data_Fragment();
                break;
            default:
                break;
        }
        if(des != null)
            MainActivity.Instance.switchFragment(this,des);
    }
}
