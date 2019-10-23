package com.example.mypager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    int index;
    ImageView imageView;
    int images[] = {R.drawable.dream01};

    public DetailFragment() {}
    @SuppressLint("ValidFragment")
    public DetailFragment(int index) {
        this.index = index;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);
        imageView = viewGroup.findViewById(R.id.image);
        imageView.setImageResource(images[index]);
        return viewGroup;
    }

    public void setImage(int index){
        imageView.setImageResource(images[index]);
    }
}
