package fr.busin.okhttp3.models;

import java.io.Serializable;

public class Voiture  implements Serializable{

    public String marque;
    public String name;
    public String couleur;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}