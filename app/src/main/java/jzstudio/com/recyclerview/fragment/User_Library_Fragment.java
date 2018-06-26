package jzstudio.com.recyclerview.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.Pages;
import com.jzstudio.toolbar.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import jzstudio.com.recyclerview.adapter.DirectoryAdapter;
import jzstudio.com.recyclerview.interfaces.RecyclerViewClickListener;
import jzstudio.com.recyclerview.model.Directory;

/**
 * Created by icm_mobile on 2018/6/22.
 */

public class User_Library_Fragment extends Fragment implements RecyclerViewClickListener{

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<Directory> mData = new ArrayList<>();
    Context context;


    @SuppressLint("ResourceType")
    public void initModel() {
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.user_library_directory_name);
        TypedArray backgrounds = resources.obtainTypedArray(R.array.directoryRipples);

        for(int i = 0; i < titles.length; i++) {
            mData.add(new Directory( titles[i] , backgrounds.getDrawable(i % 2)));
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
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_directory,container,false);
        mRecyclerView =  v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false); //版面設置為縱向
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DirectoryAdapter(mData,(MainActivity)getContext(),this);
        mRecyclerView.setAdapter(mAdapter);

        /**action bar 標題更新*/
        MainActivity.Instance.updateToolbar(Pages.DIRECTORY_USER_LIBRARY);
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



    }
}
