package com.application.consomaitre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import model.*;

public class MainActivity extends AppCompatActivity {
    private Vehicule current;
    private PleinAdaptater pleinAdaptater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestStub.devConfigManager();
        Manager manager = Manager.getInstance();

        Spinner vehiculeSelector = (Spinner)findViewById(R.id.vehicule_selector);

        ArrayList<String> vehiculeNoms = new ArrayList<>();
        for(Vehicule vehicule: manager.getVehicules()){
            vehiculeNoms.add(vehicule.getNom());
        }
        Log.d("MainActivity", vehiculeNoms.toString());
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,vehiculeNoms);
        vehiculeSelector.setAdapter(spinnerAdapter);
        vehiculeSelector.setVisibility(View.VISIBLE);
        vehiculeSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                current = manager.getVehicules().get(position);
                pleinAdaptater.onCurrentVehiculeChanged(current);
                Log.d("MainActivity","Current: " + current.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        current = manager.getVehicules().get(0);

        RecyclerView pleinList = (RecyclerView)findViewById(R.id.plein_list);
        pleinList.setLayoutManager(new LinearLayoutManager(this));
        pleinAdaptater = new PleinAdaptater(current.getPleins());
        pleinList.setAdapter(pleinAdaptater);
        pleinList.setVisibility(View.VISIBLE);
    }
}