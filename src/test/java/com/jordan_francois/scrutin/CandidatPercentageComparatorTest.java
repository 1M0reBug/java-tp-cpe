package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jordan on 26/04/16.
 */
public class CandidatPercentageComparatorTest{

    @Test
    public void compare() throws Exception {

        List<Candidat> list = new ArrayList<Candidat>();

        Candidat c1 = new Candidat(new CandidatScrutin(new HommePolitique(Civilite.HOMME, "John", "Doe", "parti 1"), 15), 0.25);
        list.add(c1);

        Candidat c2 = new Candidat(new CandidatScrutin(new HommePolitique(Civilite.HOMME, "Doe", "John", "parti 2"), 15), 0.75);
        list.add(c2);


        Collections.sort(list, new CandidatPercentageComparator());

        assertEquals(list.get(0), c1);
    }

    @Test
    public void reversed() throws Exception {
        List<Candidat> list = new ArrayList<Candidat>();

        Candidat c1 = new Candidat(new CandidatScrutin(new HommePolitique(Civilite.HOMME, "John", "Doe", "parti 1"), 15), 0.25);
        list.add(c1);

        Candidat c2 = new Candidat(new CandidatScrutin(new HommePolitique(Civilite.HOMME, "Doe", "John", "parti 2"), 15), 0.75);
        list.add(c2);


        Collections.sort(list, new CandidatPercentageComparator().reversed());

        assertEquals(list.get(0), c2);
    }

}