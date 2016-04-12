
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

    public HommePolitique(Civilite civilite, string nom, string prenom, string parti)
    {
    	this.civilite = civilite;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.nomParti = parti;
    }
    
    @Override
    public String toString() {
        return "[Civilité : " + this.civilite+
        		", nom : " + this.nom + ", Parti : " + this.nomParti +"]";
    }
    
    public static void main()
    {
    	HommePolitique h1, h2, h3;
    	h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
    	h3 = new HommePolitique(Civilite.HOMME,"nom3","parti3");
    	h1.toString();
    }
}
