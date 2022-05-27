package model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Manager {
    public static Manager instanceDeClasse;
    private ArrayList<Vehicule> vehicules;

    public Manager(){
        vehicules = new ArrayList<>();
    }

    public static Manager getInstance(){
        if(instanceDeClasse == null)
            instanceDeClasse = new Manager();
        return instanceDeClasse;
    }

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @NonNull
    @Override
    public String toString() {
        String string = new String();
        string = "===========\n";
        for (Vehicule current : vehicules){
            string = string + "\n" + current.toString();
        }
        return string;
    }
}
