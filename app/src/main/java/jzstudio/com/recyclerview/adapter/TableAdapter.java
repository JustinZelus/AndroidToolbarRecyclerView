package jzstudio.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jzstudio.toolbar.recyclerview.R;

import java.util.List;

import jzstudio.com.recyclerview.interfaces.IRecyclerViewClickListener;
import jzstudio.com.recyclerview.model.Table;

/**
 * Created by icm_mobile on 2018/6/27.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder>{

    private List<Table> mData;
    private Context context;
    private IRecyclerViewClickListener recyclerViewClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.tv_view);
        }

        @Override
        public void onClick(View v) {
            Log.d("TableAdapter onClick : "," " + this.getAdapterPosition());
        }
    }

    public TableAdapter(List<Table> mData ,Context context,IRecyclerViewClickListener recyclerViewClickListener) {
        this.mData = mData;
        this.context = context;
        this. recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
