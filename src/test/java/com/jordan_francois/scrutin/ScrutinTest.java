package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import fichiersPourTp.tp2.Vote;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by jordan on 26/04/16.
 */
public class ScrutinTest {
    @Test
    public void getResult() throws Exception {

        List<HommePolitique> hommePolitiques = new ArrayList< HommePolitique>();
        hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek", "Oxlama", "parti1"));
        hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Nicolai", "Tarcozi", "parti2"));

        Scrutin scrutin = null;
        int dateScrutin = 15;
        int dateBulletin = 13;
        int population = 30;

        scrutin = new Scrutin(hommePolitiques, population, dateScrutin);

        Vote vote = null;
        vote = new BulletinElectronique(hommePolitiques.get(0), dateBulletin, dateScrutin);
        scrutin.addBulletin(vote);

        vote = new BulletinPapier(hommePolitiques.get(1), dateBulletin, dateScrutin, true);
        scrutin.addBulletin(vote);

        List<Candidat> expected = new ArrayList<Candidat>();

        CandidatScrutin cs1 = new CandidatScrutin(hommePolitiques.get(0), dateScrutin);
        CandidatScrutin cs2 = new CandidatScrutin(hommePolitiques.get(1), dateScrutin);
        cs1.incrementerNombreVoix();
        cs2.incrementerNombreVoix();

        Candidat c1 = new Candidat(cs1, 0.5);
        Candidat c2 = new Candidat(cs2, 0.5);

        expected.add(c1);
        expected.add(c2);

        assertThat(scrutin.getResult(), is(expected));
    }

}