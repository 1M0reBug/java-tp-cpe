package com.jordanEtFrancois.srutin;
import fichiersPourTp.tp1.Civilite;

public class HommePolitique {

    private Civilite civilite;
    private String nom;
    private String prenom;
    private String nomParti;

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
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

    public String getNomParti() {
        return nomParti;
    }

    public void setNomParti(String nomParti) {
        this.nomParti = nomParti;
    }

    public HommePolitique(Civilite civilite, String nom, String prenom, String nomParti) {

        this.nom = nom;
        this.prenom = prenom;
        this.nomParti = nomParti;
        this.civilite = civilite;
    }

    @Override
    public String toString() {
        return  "[ civilite = " + civilite +
                ", nom = '"  + nom + '\'' +
                ", prenom = '" + prenom + '\'' +
                ", nomParti = '" + nomParti + '\'' +
                ']';
    }

    public static void main(String[] args) {
        HommePolitique h = new HommePolitique(Civilite.HOMME, "Doe", "John", "In tartiflette we trust");
        System.out.println(h);
    }
}
