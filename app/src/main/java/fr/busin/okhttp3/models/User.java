package fr.busin.okhttp3.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrien on 11/10/2017.
 */

public class User {

    public ArrayList<Voiture> voitures;
    public String nom;
    public String prenom;
    public Integer age;
    public Boolean permis;


    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(ArrayList<Voiture> voitures) {
        this.voitures = voitures;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getPermis() {
        return permis;
    }

    public void setPermis(Boolean permis) {
        this.permis = permis;
    }
}
