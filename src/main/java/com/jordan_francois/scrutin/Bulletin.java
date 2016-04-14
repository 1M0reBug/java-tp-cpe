package com.jordan_francois.scrutin;

import fichiersPourTp.tp2.Vote;

/**
 * Created by jordan on 14/04/16.
 */
public abstract class Bulletin implements Vote {


    protected HommePolitique hommePolitique;
    protected int dateBulletin;
    protected int dateScrutin;

    public Bulletin(HommePolitique hommePolitique, int dateBulletin, int dateSrutin) {

        this.hommePolitique = hommePolitique;
        this.dateBulletin = dateBulletin;
        this.dateScrutin = dateSrutin;
    }

    @Override
    public abstract boolean estInvalide();

    @Override
    public String toString() {
        return "Vote par " + this.getClass().getSimpleName() +
                " pour " + this.hommePolitique +
                "-> " + ( this.estInvalide()  ? "invalide" : "valide" ) ;
    }

    @Override
    public HommePolitique getHommePolitique() {
        return this.hommePolitique;
    }

    @Override
    public int getDate() {
        return this.dateBulletin;
    }

}
