package fr.projet.lokacar.models;

import java.io.Serializable;

/**
 * Created by mdossantos2015 on 02/05/2017.
 */

public class Vehicule implements Serializable {


    private String id;
    private String marque;
    private String model;
    private int kilometre;
    private String energie;
    private int nbPlace;
    private Double tarifHoraire;
    private String annee;
    private String din;
    private String photo;

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDin() {
        return din;
    }

    public void setDin(String din) { this.din = din; }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(Double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

}
