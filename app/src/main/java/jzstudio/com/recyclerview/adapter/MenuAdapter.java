package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jzstudio.toolbar.recyclerview.R;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.interfaces.RecyclerViewClickListener;
import jzstudio.com.recyclerview.model.MyMenu;


/**
 * Created by icm_mobile on 2018/6/22.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    MyMenu mDataset;
    int width = 0;
    Context context;
    static RecyclerViewClickListener mRecyclerViewClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
            mTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mRecyclerViewClickListener.recyclerViewItemClicked(v,this.getAdapterPosition());
        }
    }



    public MenuAdapter(MyMenu mDataset, MainActivity activity, RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mDataset = mDataset;
        this.context = activity;
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
        /* 取屏幕的寬度來計算按鈕的寬*/
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_text_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(tv);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset.getTitles()[position]);
        holder.mTextView.getLayoutParams().width = width/mDataset.size();
        holder.mTextView.setBackground(mDataset.getBackground(position));
        //        holder.mTextView.setBackgroundColor(mDataset.getColors()[position]);



    }

//    View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v,int position) {
//
//            switch (page) {
//                case Pages.DIRECTORY:
//                    break;
//                case Pages.Temperature:
//                    break;
//                case Pages.Setup:
//                    break;
//            }
//            MainActivity.switchFragment(position);
//        }
//    };

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
