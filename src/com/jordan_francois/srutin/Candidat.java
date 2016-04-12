package com.jordan_francois.srutin;

/**
 * Created by jordan on 12/04/16.
 */
public class Candidat {
    private CandidatScrutin candidatScrutin;
    private double pourcentage;

    public Candidat(CandidatScrutin candidatScrutin, double pourcentage) {
        this.candidatScrutin = candidatScrutin;
        this.pourcentage = pourcentage;
    }

    public CandidatScrutin getCandidatScrutin() {

        return candidatScrutin;
    }


    public double getPourcentage() {
        return pourcentage;
    }


    @Override
    public String toString() {
        return "Candidat{" +
                "candidatScrutin = " + candidatScrutin +
                ", pourcentage = " + pourcentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidat)) return false;

        Candidat candidat = (Candidat) o;

        if (Double.compare(candidat.getPourcentage(), getPourcentage()) != 0) return false;
        return !(getCandidatScrutin() != null ? !getCandidatScrutin().equals(candidat.getCandidatScrutin()) : candidat.getCandidatScrutin() != null);

    }

    public boolean compareCandidatScrutin(CandidatScrutin candidatScrutin  )
    {
        return this.candidatScrutin.equals(candidatScrutin);
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getCandidatScrutin() != null ? getCandidatScrutin().hashCode() : 0;
        temp = Double.doubleToLongBits(getPourcentage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
