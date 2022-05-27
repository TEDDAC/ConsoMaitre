package com.application.consomaitre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //enable back button (up button)
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
}