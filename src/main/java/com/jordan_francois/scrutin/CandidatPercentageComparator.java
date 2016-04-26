package com.jordan_francois.scrutin;

import java.util.Comparator;

/**
 * Created by jordan on 26/04/16.
 */
public class CandidatPercentageComparator implements Comparator<Candidat> {

    @Override
    public int compare(Candidat o1, Candidat o2) {
        return new Double(o1.getPourcentage()).compareTo( new Double(o2.getPourcentage()) );
    }

}
