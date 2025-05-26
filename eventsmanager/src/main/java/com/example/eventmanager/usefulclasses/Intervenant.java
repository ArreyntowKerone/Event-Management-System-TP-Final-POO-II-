package com.example.eventmanager.usefulclasses;

public class Intervenant {
    private String nom;
    private String email;
    private String profession;
    private int age;

    public Intervenant(String nom) {
        this.nom = nom;
    }
    public Intervenant(String nom, String email, String profession, int age) {
        this.nom = nom;
        this.email = email;
        this.profession = profession;
        this.age = age;
    }
    //Getters and setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
