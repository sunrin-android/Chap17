package com.example.mypager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class TextViewPagerAdapter extends PagerAdapter {
    Context context;

    // 생성자
    public TextViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5; // 화면 생성
    }

    // 화면 생성
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pager, container, false);

        TextView textView = view.findViewById(R.id.title);
        textView.setText("Text : " + position);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        Toast.makeText(context, "isViewFrom", Toast.LENGTH_SHORT).show();
        return (view == (View)object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Toast.makeText(context, "destroy : " + position, Toast.LENGTH_SHORT).show();
        container.removeView((View)object);
    }
}
