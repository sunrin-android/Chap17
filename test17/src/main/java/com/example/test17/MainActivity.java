package com.example.test17;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<Item>();

        // DB에서 데이터 검색해서 list에 add
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM tb_data WHERE date='2019-11-01'";
        String ysql = "SELECT * FROM tb_data WHERE date='2019-10-31'";
        String psql = "SELECT * FROM tb_data WHERE date!='2019-10-31' AND date !='2019-11-01'";
        Cursor cursor = db.rawQuery(sql, null);
        Cursor yCursor = db.rawQuery(ysql, null);
        Cursor pCursor = db.rawQuery(psql, null);

        if (cursor.getCount() != 0) {
            // 오늘 header
            HeaderItem item = new HeaderItem();
            item.title = "오늘";
            list.add(item);

            while (cursor.moveToNext()) {
                // 오늘 data
                DataItem dataItem = new DataItem();
                dataItem.name = cursor.getString(1);
                dataItem.date = cursor.getString(2);
                list.add(dataItem);
            }
        }

        // 어제 통화기록
        if (yCursor.getCount() != 0) {
            // 어제 header
            HeaderItem item = new HeaderItem();
            item.title = "어제";
            list.add(item);

            while (yCursor.moveToNext()) {
                // 어제 data
                DataItem dataItem = new DataItem();
                dataItem.name = yCursor.getString(1);
                dataItem.date = yCursor.getString(2);
                list.add(dataItem);
            }
        }

        // 이전 통화기록
        if (pCursor.getCount() != 0) {
            // 이전 header
            HeaderItem item = new HeaderItem();
            item.title = "이전";
            list.add(item);

            while (pCursor.moveToNext()) {
                // 이전 data
                DataItem dataItem = new DataItem();
                dataItem.name = pCursor.getString(1);
                dataItem.date = pCursor.getString(2);
                list.add(dataItem);
            }
        }

        // 어댑터 생성
        ItemAdapter adapter = new ItemAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyDecoration myDecoration = new MyDecoration();
        recyclerView.addItemDecoration(myDecoration);
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            // 현재 view의 position 가져오기
            int position = parent.getChildAdapterPosition(view);
            // 현재 item 가져오기
            Item item = list.get(position);
            if (item.getType() == item.TYPE_DATA) {
                view.setBackgroundColor(0xFFFFFFFF);
                ViewCompat.setElevation(view, 10.0f);
            }
            outRect.set(20, 10, 20, 10);
        }
    }
}
