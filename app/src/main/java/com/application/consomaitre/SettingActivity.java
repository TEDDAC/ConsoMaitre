package com.application.consomaitre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import model.Manager;

public class SettingActivity extends AppCompatActivity {
    private Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        manager = Manager.getInstance();

        //enable back button (up button)
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView vehiculeList = (RecyclerView)findViewById(R.id.vehicules_list);
        vehiculeList.setLayoutManager(new LinearLayoutManager(this));
        VehiculeAdaptater vehiculeAdaptater = new VehiculeAdaptater(manager.getVehicules());
        vehiculeList.setAdapter(vehiculeAdaptater);
        vehiculeList.setVisibility(View.VISIBLE);
    }
}