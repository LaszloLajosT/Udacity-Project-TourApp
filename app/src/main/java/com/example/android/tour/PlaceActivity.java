package com.example.android.tour;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PlaceFragment())
                .commit();
    }
}