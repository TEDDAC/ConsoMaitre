package com.application.consomaitre;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Manager;
import model.Vehicule;

public class VehiculeAdaptater extends RecyclerView.Adapter<VehiculeAdaptater.ViewHolder>{
    private ArrayList<Vehicule> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final EditText nomVehiculeEditText;
        private final TextView kilometrageTextView;

        public ViewHolder(View view) {
            super(view);

            nomVehiculeEditText = (EditText)view.findViewById(R.id.vehicule_nom_imput);
            kilometrageTextView = (TextView)view.findViewById(R.id.kilometrage_vehicule_card);

            Button delVehiculeBtn = (Button)view.findViewById(R.id.del_vehicule_button);
            delVehiculeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Manager.getInstance().getVehicules().remove(position);
                    ((SettingActivity)view.getContext()).getVehiculeAdaptater().notifyItemRemoved(position);
                    Log.d("VehiculeAdaptater",view.getContext().toString());
                }
            });
        }

        public EditText getNomVehiculeEditText() {
            return nomVehiculeEditText;
        }

        public TextView getKilometrageTextView(){ return kilometrageTextView; };
    }

    public VehiculeAdaptater(ArrayList<Vehicule> Vehicules){
        this.localDataSet = Vehicules;
    }

    @NonNull
    @Override
    public VehiculeAdaptater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vehicule_card,parent, false);
        Log.d("VehiculeAdaptater","onCreateViewHolder");
        return new VehiculeAdaptater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculeAdaptater.ViewHolder holder, int position) {
        Vehicule current = localDataSet.get(position);
        holder.getNomVehiculeEditText().setText(current.getNom());
        holder.getKilometrageTextView().setText(current.getKilometrage() + " km");
        holder.getNomVehiculeEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                current.setNom(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Log.d("VehiculeAdaptater:","onBindViewHolder");
    }

    @Override
    public int getItemCount(){
        return localDataSet.size();
    }
}
