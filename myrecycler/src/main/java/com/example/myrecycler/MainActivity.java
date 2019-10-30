package com.example.myrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            list.add("item = " + i);
        }

        // 어댑터 생성
        myAdapter = new MyAdapter(list);
        // recyclerView에 어댑터 세팅
        recyclerView.setAdapter(myAdapter);
        // item 배치
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // ItemDecoration
        recyclerView.addItemDecoration(new MyItemDecoration());

        // itemTouchHelper 사용
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(myAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
