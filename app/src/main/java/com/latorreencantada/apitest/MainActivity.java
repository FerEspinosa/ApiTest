package com.latorreencantada.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.latorreencantada.apitest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplicationContext()).getComponent().inject(this);
    }
}