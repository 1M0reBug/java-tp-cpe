package com.jordan_francois.scrutin;

import fichiersPourTp.tp2.CheckSigneBulletin;
import fichiersPourTp.tp2.Vote;

/**
 * Created by jordan on 14/04/16.
 */
public class BulletinPapier extends Bulletin implements CheckSigneBulletin{

    private boolean signature;




    public BulletinPapier(HommePolitique hommePolitique, int dateBulletin, int dateSrutin, boolean signature) {
        super(hommePolitique, dateBulletin, dateSrutin);
        this.signature = signature;
    }


    @Override
    public boolean estInvalide() {
        return !( checkSigne() );

    }

    @Override
    public boolean checkSigne() {
        return signature;
    }
}
