package com.example.myfragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detail = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail);
    }

    public void detailView(int index) {
        Configuration configuration = getResources().getConfiguration();
        if (Configuration.ORIENTATION_PORTRAIT == configuration.orientation) {
            detail = new DetailFragment(index);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, detail).commit();
            fragmentTransaction.addToBackStack(null);
        } else {
            detail.setImage(index);
        }
    }
}
