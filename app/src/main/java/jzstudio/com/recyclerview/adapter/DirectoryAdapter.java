package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jzstudio.toolbar.recyclerview.R;

import java.util.List;

import jzstudio.com.recyclerview.MainActivity;
import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;

import jzstudio.com.recyclerview.model.Directory;

/**
 * Created by icm_mobile on 2018/6/22.
 */

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.ViewHolder> {

    List<Directory> mData;
    int width = 0;
    Context context;
    static IRecyclerViewClickListener mRecyclerViewClickListener;

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



    public DirectoryAdapter(List<Directory> mData, MainActivity activity, IRecyclerViewClickListener mRecyclerViewClickListener) {
        this.mData = mData;
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
        holder.mTextView.setText(mData.get(position).getTitle());
        holder.mTextView.setBackground(mData.get(position).getBackground());
//        holder.mTextView.setBackground( (position % 2) == 0 ? mData.get(position).getBackground_0() : mData.get(position).getBackground_1());


    }

    public void removeItem(int position) {
        mData.remove(position);

        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



}
