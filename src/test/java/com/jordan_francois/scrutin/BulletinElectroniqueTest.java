package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordan on 14/04/16.
 */
public class BulletinElectroniqueTest {

    @Test
    public void testToStringValide() throws Exception {
        HommePolitique hp = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
        BulletinElectronique bc = new BulletinElectronique(hp, 9, 11);


        String expected = "Vote par BulletinElectronique pour " + hp + "-> valide";
        assertEquals(expected, bc.toString());
    }

    @Test
    public void testShouldReturnInvalidIfBulletinComesToLate() {
        HommePolitique hp = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
        BulletinElectronique bc = new BulletinElectronique(hp, 10, 11);

        assertTrue(bc.estInvalide());
    }

    @Test
    public void testShouldReturnValidIfBulletinComesToLate() {
        HommePolitique hp = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
        BulletinElectronique bc = new BulletinElectronique(hp, 9, 11);

        assertFalse(bc.estInvalide());
    }

}