package com.application.consomaitre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
                Log.d("MainActivity","Current: " + current.toString());
                RecyclerView pleinList = (RecyclerView)findViewById(R.id.plein_list);
                pleinList.setLayoutManager(new LinearLayoutManager(view.getContext()));
                pleinList.setAdapter(new PleinAdaptater(current.getPleins()));
                pleinList.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        current = manager.getVehicules().get(0);

    }
}