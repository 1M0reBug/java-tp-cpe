package com.jordan_francois.scrutin;

import fichiersPourTp.tp1.Civilite;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jordan on 14/04/16.
 */
public class BulletinPapierTest {

    @Test
    public void testToStringValide() {
        HommePolitique hp = new HommePolitique(Civilite.HOMME, "John", "Doe", "in tartiflette we trust");
        BulletinCourrier bc = new BulletinCourrier(hp, 11, 11, true);

        String expected = "Vote par BulletinCourrier pour " + hp + "-> valide";
        assertEquals(expected, bc.toString());
    }

}