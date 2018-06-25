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
import jzstudio.com.recyclerview.adapter.DirectoryAdapter;
import jzstudio.com.recyclerview.interfaces.RecyclerViewClickListener;
import jzstudio.com.recyclerview.model.OffLine;

/**
 * Created by icm_mobile on 2018/6/22.
 */

public class Directory_KXF_Fragment extends Fragment implements RecyclerViewClickListener {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    OffLine myDataset;
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();




        Resources resources = context.getResources();
        /** directory頁面是一排list，每一個item都是一個資料夾*/
        myDataset = new OffLine(MainActivity.Instance.getDirectory_Names_KXF(),resources.obtainTypedArray(R.array.directoryRipples));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_directory,container,false);
        mRecyclerView =  v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false); //版面設置為縱向
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DirectoryAdapter(myDataset,(MainActivity)getContext(),this);
        mRecyclerView.setAdapter(mAdapter);

        /**action bar 標題更新*/
        MainActivity.Instance.updateToolbar(Pages.DIRECTORY_KXF);
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

        Fragment des = new Menu_2_Button_Fragment();


        Log.d("recyclerViewItemClicked","position - " + position+ " , " + ((TextView)v).getText() + "\r\n");

        if(des != null)
            MainActivity.Instance.switchFragment(this,des);

    }
}
