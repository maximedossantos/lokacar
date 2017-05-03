package fr.projet.lokacar.models;

/**
 * Created by agirardeau2015 on 03/05/2017.
 */

public class Client {
    private int idClient;
    private String name;
    private String surname;
    private String birthDate;
    private String email;

    public int getIdClient() {return idClient;}

    public void setIdClient(int idClient) {this.idClient = idClient;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getBirthDate() {return birthDate;}

    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
