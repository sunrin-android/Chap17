package com.example.myrecycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(android.R.id.text1);
    }

}
