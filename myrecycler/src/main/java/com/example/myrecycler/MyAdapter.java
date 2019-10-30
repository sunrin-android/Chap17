package com.example.myrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemTouchHelperCallback.ItemTouchHelperListener {
    // 데이터 변수
    ArrayList<String> list;

    // 생성자 - MainActivity에서 어댑터 생성할 때 데이터 받기
    MyAdapter(ArrayList<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item 1개 화면 inflation -> 메모리 객체화
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        // 각각의 view findViewById 찾기 -> ViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Holder에 있는 view 객체에 data 세팅
        // listView에서는 getView() 메소드에 해당
        holder.titleView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        // fromPosition 삭제, toPosition 추가
        // 현재 item 가져오기
        String fromItem = list.get(fromPosition);
        // 삭제
        list.remove(fromPosition);
        // 추가
        list.add(toPosition, fromItem);
        // 새로고침
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemRemove(int position) {
        list.remove(position);
        notifyDataSetChanged();
//        notifyItemRemoved();
    }
}
