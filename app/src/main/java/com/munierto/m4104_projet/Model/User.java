package com.munierto.m4104_projet.Model;

/**
 * Created by -Toshiba- on 27/09/2016.
 */
public class User {
    //Attributs
    private String pseudo;
    private String nom;
    private String prenom;
    private String avatar;
    private int levelMath;
    private int bestScoreCulture;

    //Constructeurs

    public User(String pseudo, String nom, String prenom, int levelMath, int bestScoreCulture) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.levelMath = levelMath;
        this.bestScoreCulture = bestScoreCulture;
        this.avatar = "avatar";
    }

    public User(){

    }
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getLevelMath() {
        return levelMath;
    }

    public void setLevelMath(int levelMath) {
        this.levelMath = levelMath;
    }

    public int getBestScoreCulture() {
        return bestScoreCulture;
    }

    public void setBestScoreCulture(int bestScoreCulture) {
        this.bestScoreCulture = bestScoreCulture;
    }



}
