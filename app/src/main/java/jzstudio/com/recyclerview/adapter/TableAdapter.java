package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.List;

import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;
import jzstudio.com.recyclerview.interfaces.ITableVIewClickListener;
import jzstudio.com.recyclerview.model.Table;

/**
 * Created by icm_mobile on 2018/6/27.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder>{

    private List<Table> mData;
    private static Context context;
    private static IRecyclerViewClickListener recyclerViewClickListener;
//    private static ITableVIewClickListener tableVIewClickListener;
    private static TextView lastTextView;



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tv_view);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("TableAdapter onClick : "," " + this.getAdapterPosition());
            int position = this.getAdapterPosition();
            //上方第一排是欄位名稱
            //左邊第一排是欄位名稱
            if(position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6)
                return;
            if(position % 7 == 0)
                return;

            TextView currentTextView = (TextView)v;
            recyclerViewClickListener.recyclerViewItemClicked(currentTextView,position);
            if(currentTextView.equals(lastTextView)) return;
            if(lastTextView != null)
                lastTextView.setBackground(getOriginalColor());
            currentTextView.setBackground(getHighlightColor());
            lastTextView = currentTextView;
        }
    }

    public TableAdapter(List<Table> mData ,Context context,IRecyclerViewClickListener recyclerViewClickListener) {
        this.mData = mData;
        this.context = context;
        this.recyclerViewClickListener = recyclerViewClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.table_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private static Drawable getOriginalColor() {
        return  context.getResources().getDrawable(R.drawable.gradient_black,context.getTheme());
    }

    private static Drawable getHighlightColor() {
        return  context.getResources().getDrawable(R.drawable.gradient_text_highlight,context.getTheme());
    }

}
