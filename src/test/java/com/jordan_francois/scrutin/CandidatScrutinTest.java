package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordan on 12/04/16.
 */
public class CandidatScrutinTest {

    private HommePolitique hp;
    private CandidatScrutin cs;

    @Before
    public void setUp() throws Exception {
        hp = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
        cs = new CandidatScrutin(hp, 1460466792);
    }


    @Test
    public void testEqualsCandidatAndCompareCandidatShouldReturnSameResult() throws Exception {
        CandidatScrutin cs2 = new CandidatScrutin(hp, 1460466792);
        assertEquals(cs.compareCandidatScrutin(cs2), cs.equalsHommePolitique(hp));
    }
}