package com.application.consomaitre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedOutputStream;

import model.Manager;
import model.Plein;

public class PleinEditActivity extends AppCompatActivity {
    private Plein current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plein_edit);

        Manager manager = Manager.getInstance();

        Intent intent = getIntent();
        int positionPlein = intent.getIntExtra("position_plein",0);
        int positionVehicule = intent.getIntExtra("position_vehicule",0);
        Log.d("PleinEditActivity","Vehicule: " + positionPlein + " Plein: " + positionPlein);

        this.current = manager.getVehicules().get(positionVehicule).getPleins().get(positionPlein);

        EditText kilometrage = (EditText)findViewById(R.id.kilometrage_input);
        kilometrage.setText(Integer.toString(this.current.getKilometrage()));

        EditText price = (EditText)findViewById(R.id.price_input);
        price.setText(Float.toString(this.current.getPrix()));

        EditText quantite = (EditText)findViewById(R.id.quantite_input);
        quantite.setText(Float.toString(this.current.getQuantite()));

        Button saveButton = (Button)findViewById(R.id.plein_save_button);
        saveButton.setOnClickListener(view -> {
            current.setKilometrage(Integer.parseInt(kilometrage.getText().toString()));
            current.setPrix(Float.parseFloat(price.getText().toString()));
            current.setQuantite(Float.parseFloat(quantite.getText().toString()));
            finish();
        });

        Button deleteButton = (Button)findViewById(R.id.plein_delete_button);
        deleteButton.setOnClickListener(view -> {
            manager.getVehicules().get(positionVehicule).getPleins().remove(current);
            finish();
        });
    }
}