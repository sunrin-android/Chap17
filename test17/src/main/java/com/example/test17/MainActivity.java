package com.example.test17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();

        // DB에서 데이터 검색해서 list에 add
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM tb_data";
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Item item = new Item();
            item.name = cursor.getString(1);
            item.date = cursor.getString(2);
            list.add(item);
        }

        // 어댑터 생성
        ItemAdapter adapter = new ItemAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
