package com.application.consomaitre;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Vehicule;

public class VehiculeAdaptater extends RecyclerView.Adapter<VehiculeAdaptater.ViewHolder>{
    private ArrayList<Vehicule> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomVehiculeTextView;
        private final TextView kilometrageTextView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nomVehiculeTextView = (TextView)view.findViewById(R.id.nom_vehicule_card);
            kilometrageTextView = (TextView)view.findViewById(R.id.kilometrage_vehicule_card);
        }

        public TextView getNomVehiculeTextView() {
            return nomVehiculeTextView;
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
        holder.getNomVehiculeTextView().setText(current.getNom() + " ");
        holder.getKilometrageTextView().setText(current.getKilometrage() + "km");
        Log.d("VehiculeAdaptater:","onBindViewHolder");
    }

    @Override
    public int getItemCount(){
        return localDataSet.size();
    }
}
