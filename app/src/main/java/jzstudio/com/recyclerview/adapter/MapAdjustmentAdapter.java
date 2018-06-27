package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.List;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;
import jzstudio.com.recyclerview.model.Menu;

/**
 * Created by icm_mobile on 2018/6/27.
 */

public class MapAdjustmentAdapter extends RecyclerView.Adapter<MapAdjustmentAdapter.ViewHolder> {
    int height = 0;
    List<Menu> mData;
    Context context;
    static IRecyclerViewClickListener mRecyclerViewClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tv_view);
            mTextView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d("MapAdjustmentAdapter"," " + this.getAdapterPosition());
        }
    }

    public MapAdjustmentAdapter(List<Menu> mData, MainActivity activity, IRecyclerViewClickListener mRecyclerViewClickListener) {
        this.mData = mData;
        this.context = activity;
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;

         /* 取屏幕的寬度來計算按鈕的寬*/
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.height = displayMetrics.heightPixels;
    }

    @Override
    public MapAdjustmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_adjustment_view2,parent,false);

        //將view的高度減半
        int height = parent.getMeasuredHeight() / 2;
        v.getLayoutParams().height = height;
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MapAdjustmentAdapter.ViewHolder holder, int position) {
        Log.d("onBindViewHolder ","" + position);

        holder.mTextView.setText(mData.get(position).getTitle());
        holder.mTextView.setBackground(mData.get(position).getBackground());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
