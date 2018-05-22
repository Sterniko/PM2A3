package de.hawhh.informatik.sml.kino.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import de.hawhh.informatik.sml.kino.fachwerte.Platz;

public class KinosaalTest
{
    @Test
    public void testeKonstruktoren()
    {
        Kinosaal k = new Kinosaal("Name", 90, 16);
        assertEquals("Name", k.getName());
        assertEquals(90, k.getAnzahlReihen());
        assertEquals(16, k.getAnzahlSitzeProReihe());
        assertNotNull(k.toString());
    }

    @Test
    public void testeIstPlatzVorhanden()
    {
        Kinosaal k = new Kinosaal("Name", 90, 16);
        assertTrue(k.hatPlatz(Platz.get(80, 8)));
        assertFalse(k.hatPlatz(Platz.get(100, 4)));
    }

    @Test
    public void testeGibPlaetze()
    {
        Kinosaal k = new Kinosaal("Name", 3, 4);
        List<Platz> plaetze = k.getPlaetze();
        assertEquals(12, plaetze.size());
        assertTrue(plaetze.contains(Platz.get(0, 0)));
        assertTrue(plaetze.contains(Platz.get(0, 3)));
        assertTrue(plaetze.contains(Platz.get(2, 0)));
        assertTrue(plaetze.contains(Platz.get(2, 3)));
    }

    @Test
    public void testeEqualsUndHashCode()
    {
        Kinosaal k1 = new Kinosaal("Name", 90, 16);
        Kinosaal k2 = new Kinosaal("Name", 90, 16);
        assertTrue(k2.equals(k1));
        assertTrue(k1.hashCode() == k2.hashCode());
    }
}
