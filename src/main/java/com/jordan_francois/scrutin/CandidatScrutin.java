package com.jordan_francois.scrutin;
import fichiersPourTP.tp1.Civilite;

public class CandidatScrutin {

    private HommePolitique candidat;
    private int nbVoix;
    private int dateScrutin;

    public CandidatScrutin(HommePolitique candidat, int dateScrutin) throws CloneNotSupportedException {
        this.candidat = new HommePolitique(candidat);
        this.dateScrutin = dateScrutin;
        this.nbVoix = 0;
    }

    @Override
    public String toString() {
        return "CandidatScrutin {" +
                "candidat = " + candidat +
                ", nbVoix = " + nbVoix +
                ", dateScrutin = " + dateScrutin +
                '}';
    }

    public HommePolitique getCandidat() {
        return candidat;
    }

    public Civilite getCiviliteCandidat()
    {
        return getCandidat().getCivilite();
    }

    public String getNomCandidat()
    {
        return getCandidat().getNom();
    }

    public String getPrenomCandidat()
    {
        return getCandidat().getPrenom();
    }

    public String getPartiCandidat()
    {
        return getCandidat().getNomParti();
    }

    public void setCandidat(HommePolitique candidat) {
        this.candidat = candidat;
    }

    public int getNbVoix() {
        return nbVoix;
    }

    public void incrementNbVoix() {
        this.nbVoix++;
    }

    public int getDateScrutin() {
        return dateScrutin;
    }

    public void setDateScrutin(int dateScrutin) {
        this.dateScrutin = dateScrutin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidatScrutin)) return false;

        CandidatScrutin that = (CandidatScrutin) o;

        if (getNbVoix() != that.getNbVoix()) return false;
        if (getDateScrutin() != that.getDateScrutin()) return false;
        return !(getCandidat() != null ? !getCandidat().equals(that.getCandidat()) : that.getCandidat() != null);

    }

    @Override
    public int hashCode() {
        int result = getCandidat() != null ? getCandidat().hashCode() : 0;
        result = 31 * result + getNbVoix();
        result = 31 * result + getDateScrutin();
        return result;
    }

    public boolean equalsHommePolitique(HommePolitique h)
    {
        return this.candidat.equals(h);
    }

    public boolean compareCandidatScrutin(CandidatScrutin cs)
    {
        return this.equalsHommePolitique(cs.candidat);
    }

    public void incrementerNombreVoix()
    {
        this.nbVoix++;
    }
}
