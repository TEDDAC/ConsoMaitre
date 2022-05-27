package model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Vehicule {
    private String nom;

    private ArrayList<Plein> pleins;

    public Vehicule(String nom){
        this.nom = nom;
        this.pleins = new ArrayList<Plein>();
    }

    public ArrayList<Plein> getPleins() {
        return pleins;
    }

    public void setPleins(ArrayList<Plein> pleins) {
        this.pleins = pleins;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @NonNull
    @Override
    public String toString() {
        String string = new String();
        string = "----\nNom: " + this.nom + " > " + pleins.size() + " pleins\n";
        for(Plein current: pleins){
            string = string + "\t" + current + "\n";
        }
        return string;
    }
}
