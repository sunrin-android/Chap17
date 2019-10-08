package com.example.chap17;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        // Fragment 생성
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        // 첫 번째 Fragment 화면에 보여주기
        manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayout, oneFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {
        if (view == button1) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.linearLayout, oneFragment);
            fragmentTransaction.commit();
        } else if (view == button2) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.linearLayout, twoFragment);
            fragmentTransaction.commit();
        } else if (view == button3) {
            threeFragment.show(manager, null);
        }
    }
}
