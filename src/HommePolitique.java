/**
 * Created by jordan on 12/04/16.
 */
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

    public HommePolitique() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "HommePolitique{}";
    }
}
