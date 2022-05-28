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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.*;

public class MainActivity extends AppCompatActivity {
    private Vehicule current;
    private PleinAdaptater pleinAdaptater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","OnCreate");
        setContentView(R.layout.activity_main);

        Spinner vehiculeSelector = (Spinner)findViewById(R.id.vehicule_selector);

        //load model
        if(!Manager.isInstantiated())
            TestStub.devConfigManager();
        Manager manager = Manager.getInstance();

        //on redirige vers les settings s'il n'y a pas de véhicule
        if(manager.getVehicules().size() == 0){
            Intent intentSecur = new Intent(this, SettingActivity.class);
            startActivity(intentSecur);
        }

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
                TextView kilometrage = (TextView)findViewById(R.id.kilometrage);
                kilometrage.setText(Integer.toString(current.getKilometrage()));
                TextView consoMoy = (TextView)findViewById(R.id.moy_conso);
                consoMoy.setText(new DecimalFormat("#.##").format(current.getConsoMoy()));
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

        Button settingsBtn = (Button)findViewById(R.id.settings_btn);
        settingsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SettingActivity.class);
            startActivity(intent);
        });

        Button addBtn = (Button)findViewById(R.id.add_plein_button);
        addBtn.setOnClickListener(view -> {
            Plein nouvPlein = new Plein(current.getKilometrage(),0,0);
            current.getPleins().add(nouvPlein);

            Intent intent = new Intent(view.getContext(), PleinEditActivity.class);
            intent.putExtra("position_plein",current.getPleins().indexOf(nouvPlein));
            int positionVehicule = Manager.getInstance().getVehicules().indexOf(((MainActivity)(view.getContext())).getCurrent());
            intent.putExtra("position_vehicule",positionVehicule);
            view.getContext().startActivity(intent);
        });

        Log.d("MainActivity","Created");
    }

    @Override
    protected void onResume() {
        super.onResume();
        pleinAdaptater.notifyDataSetChanged();

        Spinner vehiculeSelector = (Spinner)findViewById(R.id.vehicule_selector);
        int index = Manager.getInstance().getVehicules().indexOf(current);
        vehiculeSelector.setSelection(index);

        TextView kilometrage = (TextView)findViewById(R.id.kilometrage);
        kilometrage.setText(Integer.toString(current.getKilometrage()));

        TextView consoMoy = (TextView)findViewById(R.id.moy_conso);
        consoMoy.setText(new DecimalFormat("#.##").format(current.getConsoMoy()));

        Log.d("MainActivity","OnResume");
    }

    public Vehicule getCurrent() {
        return current;
    }
}