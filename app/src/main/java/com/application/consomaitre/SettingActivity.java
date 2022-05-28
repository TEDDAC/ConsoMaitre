package com.application.consomaitre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toolbar;

import model.Manager;
import model.Plein;
import model.Vehicule;

public class SettingActivity extends AppCompatActivity {
    private Manager manager;
    private VehiculeAdaptater vehiculeAdaptater;

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
        vehiculeAdaptater = new VehiculeAdaptater(manager.getVehicules());
        vehiculeList.setAdapter(vehiculeAdaptater);
        vehiculeList.setVisibility(View.VISIBLE);

        Button addVehiculeBtn = (Button)findViewById(R.id.add_vehicule_button);
        addVehiculeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.getVehicules().add(new Vehicule("Nouveau Véhicule"));
                vehiculeAdaptater.notifyItemInserted(manager.getVehicules().size()-1);
            }
        });
    }

    public VehiculeAdaptater getVehiculeAdaptater() {
        return vehiculeAdaptater;
    }
}