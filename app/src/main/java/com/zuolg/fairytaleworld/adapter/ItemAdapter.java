package com.zuolg.fairytaleworld.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zuolg.fairytaleworld.R;

import java.util.ArrayList;

/**
 * @author ZuoLangGuo
 * @time 2016/9/14 14:26
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewHolder>  implements View.OnClickListener {
    private ArrayList<String> items = new ArrayList<>();

    private int colorRes = 0;

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    public ItemAdapter(ArrayList<String> items,int colorRes) {
        this.items = items;
        this.colorRes = colorRes;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card,
                viewGroup, false);
        CardView cardView = (CardView) view.findViewById(R.id.card_view);
        if (colorRes != 0) {
            cardView.setCardBackgroundColor(colorRes);
        }

        view.setOnClickListener(this);
        return new viewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int position) {
        String info = items.get(position);
        View view = viewHolder.itemView;
        TextView textView = (TextView) view.findViewById(R.id.info_text);
        textView.setText(info);
        viewHolder.itemView.setTag(info);
        //手动更改高度，不同位置的高度有所不同
        //textView.setHeight(100 + (position % 3) * 30);
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}