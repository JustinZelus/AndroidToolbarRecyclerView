package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jzstudio.toolbar.recyclerview.R;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.interfaces.RecyclerViewClickListener;

import jzstudio.com.recyclerview.model.OffLine;

/**
 * Created by icm_mobile on 2018/6/22.
 */

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.ViewHolder> {

    OffLine mDataset;
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



    public DirectoryAdapter(OffLine mDataset, MainActivity activity, RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mDataset = mDataset;
        this.context = activity;
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_text_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(tv);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset.getTitle(position));
        holder.mTextView.setBackground(mDataset.getBackground(position % 2));


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
