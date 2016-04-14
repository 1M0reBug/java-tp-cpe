package com.jordan_francois.scrutin;

import fichiersPourTp.tp2.CheckDateBulletin;
import fichiersPourTp.tp2.CheckSigneBulletin;
import fichiersPourTp.tp2.Vote;

/**
 * Created by jordan on 14/04/16.
 */
public class BulletinCourrier extends Bulletin implements CheckDateBulletin, CheckSigneBulletin{

    private boolean signature;
    
    public BulletinCourrier(HommePolitique hommePolitique, int dateBulletin, int dateSrutin, boolean signature) {
        super(hommePolitique, dateBulletin, dateSrutin);
        this.signature = signature;
    }

    @Override
    public boolean estInvalide() {
        return !( checkDate() && checkSigne() );

    }

    @Override
    public boolean checkDate() {
        return this.dateBulletin <= this.dateScrutin;
    }

    @Override
    public boolean checkSigne() {
        return this.signature;
    }
}
