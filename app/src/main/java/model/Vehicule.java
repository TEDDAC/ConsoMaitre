package model;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Vehicule {
    private String nom;

    private ArrayList<Plein> pleins;

    public Vehicule(String nom){
        this.nom = nom;
        this.pleins = new ArrayList<Plein>();
    }

    public ArrayList<Plein> getPleins() {
        pleins.sort((plein, t1) -> Integer.compare(t1.getKilometrage(), plein.getKilometrage()));
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
        for(Plein current: getPleins()){
            string = string + "\t" + current + "\n";
        }
        return string;
    }

    public int getKilometrage(){
        if(getPleins().size() <= 0)
            return 0;
        return Collections.max(pleins).getKilometrage();
    }

    public float getConsoMoy(){
        ArrayList<Plein> pleinsTraitement = getPleins();
        if(pleinsTraitement.size() < 2)
            return 0;
        return 100 * pleinsTraitement.get(0).getQuantite() / (pleinsTraitement.get(0).getKilometrage() - pleinsTraitement.get(1).getKilometrage());
    }
}
