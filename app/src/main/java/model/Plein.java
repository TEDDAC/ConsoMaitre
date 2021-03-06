package model;

import androidx.annotation.NonNull;

public class Plein implements Comparable {
    private int kilometrage;
    private float prix; //Total
    private float quantite;

    public Plein(int kilometrage, float prix, float quantite){
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    @NonNull
    @Override
    public String toString() {
        return "Kilometrage: " + kilometrage +"\tPrix: " + prix + "€/L\tQuantite: " + quantite;
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != getClass());
        Plein other = (Plein)o;
        return Integer.compare(getKilometrage(),other.getKilometrage());
    }
}
