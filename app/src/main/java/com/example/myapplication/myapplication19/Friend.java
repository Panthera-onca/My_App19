package com.example.myapplication.myapplication19;

public class Friend {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
