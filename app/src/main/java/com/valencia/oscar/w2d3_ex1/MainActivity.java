package com.valencia.oscar.w2d3_ex1;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.receiveMessageListener,
        SecondFragment.receiveMessageListener{
    android.support.v4.app.FragmentManager fragmentManager; //needs to be from v4 with AppCompat
    android.support.v4.app.FragmentManager fragmentManager2;
    SecondFragment secondFragment;
    FirstFragment firstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.firstContainer, firstFragment)
                .commit();

        secondFragment = new SecondFragment();
        fragmentManager2 = getSupportFragmentManager();
        fragmentManager2.beginTransaction()
                .replace(R.id.secondContainer, secondFragment)
                .commit();
    }

    @Override
    public void messageFromFirstFragment(String message) {
        secondFragment.receiveMessage(message);
    }

    @Override
    public void messageFromSecondFragment(String message) {
        firstFragment.receiveMessage(message);
    }
}
