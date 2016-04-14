package com.jordan_francois.scrutin;
import fichiersPourTp.tp1.Civilite;

public class HommePolitique implements Comparable<HommePolitique>, Cloneable {

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

    public HommePolitique(HommePolitique h) {
        this.nom = h.nom;
        this.prenom = h.prenom;
        this.nomParti = h.nomParti;
        this.civilite = h.civilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HommePolitique)) return false;

        HommePolitique that = (HommePolitique) o;

        if (getCivilite() != that.getCivilite()) return false;
        if (getNom() != null ? !getNom().equals(that.getNom()) : that.getNom() != null) return false;
        if (getPrenom() != null ? !getPrenom().equals(that.getPrenom()) : that.getPrenom() != null) return false;
        return !(getNomParti() != null ? !getNomParti().equals(that.getNomParti()) : that.getNomParti() != null);

    }

    @Override
    public int hashCode() {
        int result = getCivilite() != null ? getCivilite().hashCode() : 0;
        result = 31 * result + (getNom() != null ? getNom().hashCode() : 0);
        result = 31 * result + (getPrenom() != null ? getPrenom().hashCode() : 0);
        result = 31 * result + (getNomParti() != null ? getNomParti().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[ civilite = " + civilite +
                ", nom = '" + nom + '\'' +
                ", prenom = '" + prenom + '\'' +
                ", nomParti = '" + nomParti + '\'' +
                ']';
    }

    @Override
    public int compareTo(HommePolitique o) {
        int compare = 0;
        compare += this.nom.compareTo(o.getNom());
        compare += this.prenom.compareTo(o.getPrenom());
        compare += this.nomParti.compareTo(o.getNomParti());
        compare += this.civilite.compareTo(o.getCivilite());

        return compare;
    }

}