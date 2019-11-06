package com.example.test17;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Item> list;

    // MainActivity 어댑터 생성할때 DB에 있는 데이터 받기
    ItemAdapter(ArrayList<Item> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Item.TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = list.get(position); // 1개 데이터
        if (item.getType() == Item.TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder)holder;
            HeaderItem headerItem = (HeaderItem)item;
            headerViewHolder.titleView.setText(headerItem.title);
        } else {
            MyViewHolder dataHolder = (MyViewHolder)holder;
            DataItem dataItem = (DataItem)item;
            dataHolder.nameView.setText(dataItem.name);
            dataHolder.dateView.setText(dataItem.date);

            int count = position % 5;
            if (count == 0)
                ((GradientDrawable) dataHolder.personView.getBackground()).setColor(0xff009688);
            else if (count == 1)
                ((GradientDrawable) dataHolder.personView.getBackground()).setColor(0xff4285f4);
            else if (count == 2)
                ((GradientDrawable) dataHolder.personView.getBackground()).setColor(0xff039be5);
            else if (count == 3)
                ((GradientDrawable) dataHolder.personView.getBackground()).setColor(0xff9c27b0);
            else if (count == 4)
                ((GradientDrawable) dataHolder.personView.getBackground()).setColor(0xff0097a7);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameView, dateView;
        ImageView personView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // itemView = item.xml;
            nameView = itemView.findViewById(R.id.item_name);
            dateView = itemView.findViewById(R.id.item_date);
            personView = itemView.findViewById(R.id.item_person);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.item_header);
        }
    }
}
