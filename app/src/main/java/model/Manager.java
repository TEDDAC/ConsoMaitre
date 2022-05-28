package model;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {
    public static Manager instanceDeClasse;
    private ArrayList<Vehicule> vehicules;

    public Manager(){
        vehicules = new ArrayList<>();
    }

    public static Manager getInstance(){
        if(!isInstantiated())
            instanceDeClasse = new Manager();
        return instanceDeClasse;
    }

    public ArrayList<Vehicule> getVehicules() { return vehicules; }

    public void setVehicules(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @NonNull
    @Override
    public String toString() {
        String string = new String();
        string = "===========\n";
        for (Vehicule current : getVehicules()){
            string = string + "\n" + current.toString();
        }
        return string;
    }

    public static boolean isInstantiated(){
        return instanceDeClasse != null;
    }
}
