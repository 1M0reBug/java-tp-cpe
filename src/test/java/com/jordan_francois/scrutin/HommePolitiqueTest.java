package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordan on 12/04/16.
 */
public class HommePolitiqueTest {

    private HommePolitique h1;

    @Before
    public void setUp() throws Exception {
        h1 = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
    }

    @Test
    public void testEquals() throws Exception {
        HommePolitique h2 = h1;
        assertTrue(h1.equals(h2));
    }

    @Test
    public void testNotEqualsIfValueChanged() throws Exception {
        HommePolitique h2 = new HommePolitique(h1);

        h1.setCivilite(Civilite.FEMME);

        assertFalse(h1.equals(h2));
    }

    @Test
    public void testCopareToShouldReturnZeroIfEquals() throws Exception {
        HommePolitique h2 = new HommePolitique(h1);

        assertTrue(h1.equals(h2));
        assertEquals(h1.compareTo(h2), 0);
    }

    @Test
    public void testCompareToIsNoZeroWithDifferentReferences() throws Exception {
        HommePolitique h2 = new HommePolitique(h1);
        h1.setCivilite(Civilite.FEMME);

        assertNotEquals(h1.compareTo(h2), 0);
    }
}