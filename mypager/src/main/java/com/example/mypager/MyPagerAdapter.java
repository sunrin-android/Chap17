package com.example.mypager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        // 뷰 페이저에 보여줄 Fragment 준비
        fragments = new ArrayList<Fragment>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new DetailFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
