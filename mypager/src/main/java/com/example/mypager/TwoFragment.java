package com.example.mypager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class TwoFragment extends ListFragment {
    String[] datas;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Date 준비
        datas = new String[]{"AnA", "App:ple Pi", "EDCAN", "IWOP", "RG", "Zer0pen"};
        // 어댑터 생성
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
        // 어댑터 설정
        setListAdapter(arrayAdapter);

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), datas[position], Toast.LENGTH_SHORT).show();
    }
}