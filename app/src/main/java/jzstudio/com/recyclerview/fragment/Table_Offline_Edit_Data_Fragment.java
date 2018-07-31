package jzstudio.com.recyclerview.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.Pages;
import jzstudio.com.recyclerview.adapter.DirectoryAdapter;
import jzstudio.com.recyclerview.adapter.TableAdapter;
import jzstudio.com.recyclerview.custom.GlowingText;
import jzstudio.com.recyclerview.custom.ItemDecorationAlbumColumns;
import jzstudio.com.recyclerview.custom.LinearDividerItemDecoration;
import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;
import jzstudio.com.recyclerview.model.Directory;
import jzstudio.com.recyclerview.model.Table;

import static java.security.AccessController.getContext;

/**
 * Created by icm_mobile on 2018/6/28.
 */

public class Table_Offline_Edit_Data_Fragment extends Fragment implements IRecyclerViewClickListener{
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context context;
    List<Table> mData = new ArrayList<>();
    SeekBar seekBar;
    TextView tvSeekbarValue;
    TextView tvItemView;
    GlowingText glowingText;
    Typeface font;
    boolean isAddTypeface = false;


    @SuppressLint("ResourceType")
    public void initModel() {
        Resources resources = context.getResources();
        int[] titles = resources.getIntArray(R.array.table_offline_edit_data);
        for(int i = 0; i < 49; i++) {
            mData.add(new Table("" + titles[i]));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        initModel();
        font = Typeface.createFromAsset(context.getAssets(),"fonts/absender1.ttf");
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_table,container,false);
        seekBar = v.findViewById(R.id.seekBar);
        tvSeekbarValue = v.findViewById(R.id.tv_SeekbarValue);
        mRecyclerView =  v.findViewById(R.id.my_recycler_view);

        if(isAddTypeface)
            tvSeekbarValue.setTypeface(font);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(context,7);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.addItemDecoration(new LinearDividerItemDecoration(context,((MainActivity)context).getResources().getColor(R.color.colorAccent), 44));
        mAdapter = new TableAdapter(mData , getContext() ,this);
        mRecyclerView.setAdapter(mAdapter);

//        seekBar.setMax(100);
//        seekBar.setMin(0);
//        seekBar.setMin();

        seekBar.setProgress(50);
        tvSeekbarValue.setText(""+0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("onProgressChanged","" +progress);
                if(tvSeekbarValue != null)
                    tvSeekbarValue.setText(" "+(progress-50));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int result = seekBar.getProgress() - 50;
                if(tvItemView != null)
                    tvItemView.setText("" + result);
            }
        });

        glowingText = new GlowingText(tvSeekbarValue,20f);

        /**action bar 標題更新*/
        MainActivity.Instance.setToolbarTitle(R.string.offline_edit_data);

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
        tvItemView = (TextView) v;
        String text = "" + tvItemView.getText();
        int itemValue = Integer.parseInt(text);

        Animation anim = new AlphaAnimation(0.0f,1.0f);
        anim.setDuration(30);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(10);

        if(tvSeekbarValue != null) {
            tvSeekbarValue.setText("" + itemValue);
            tvSeekbarValue.startAnimation(AnimationUtils.loadAnimation(MainActivity.Instance,android.R.anim.slide_in_left));
        }

    }
}
