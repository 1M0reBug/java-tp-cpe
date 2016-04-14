package com.jordan_francois.scrutin;

import fichiersPourTp.tp2.CheckDateBulletin;
import fichiersPourTp.tp2.Vote;

/**
 * Created by jordan on 14/04/16.
 */
public class BulletinElectronique extends Bulletin implements CheckDateBulletin{

    public BulletinElectronique(HommePolitique hommePolitique, int dateBulletin, int dateSrutin) {
        super(hommePolitique, dateBulletin, dateSrutin);
    }

    @Override
    public boolean estInvalide() {
        return ( !checkDate() );

    }


    @Override
    public boolean checkDate() {
        return this.dateBulletin <= this.dateScrutin - 2;
    }
}
