/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.data;

import java.sql.SQLException;
import java.time.Year;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;
import postorder.logica.Artikel;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author evertjan.jacobs
 */
public class DataLayerJDBCTest {

    private static DataLayerJDBC dl;
    private static int vorigJaar;

    @BeforeAll
    public static void setup() {
        try {
            String dbName = "postorder";
            System.out.println("Create database " + dbName);
            dl = new DataLayerJDBC(dbName);

            vorigJaar = Year.now().getValue() - 1;
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void tearDown() {
        try {
            dl.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Test of geefDuursteArtikelPerBestelling method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefDuursteArtikelPerBestelling() {
        System.out.println("Q1. Geef voor elke bestelling: het bestelnummer en de prijs van het duurste artikel die hierbij besteld werd(en). ");

        LinkedHashMap<Integer, Double> result = dl.geefDuursteArtikelPerBestelling();
        assertEquals(result.get(1), 5.00, 0.01);
        assertEquals(result.get(16), 32.50, 0.01);
        assertEquals(result.get(30), 35.00, 0.01);
        assertEquals(29, result.size());
    }

    /**
     * Test of geefArtikelenMinsten4xBesteld method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefArtikelenMinsten4xBesteld() {
        System.out.println("Q2. Geef het artikelnummer én de beschrijving van alle artikelen waarvan er meer dan 4 eenheden besteld geweest zijn, en dit verspreid over minstens 2 leveringen. Je hoeft geen rekening te houden met bestellingen die nog niet geleverd zijn.");
        List<Artikel> result = dl.geefArtikelenMinsten4xBesteld();

        int[] ids = {26, 16};
        for (int id : ids) {
            assertTrue(result.contains(new Artikel(id, "xxx")));
        }

        assertEquals(ids.length, result.size());
    }

    /**
     * Test of geefDatumsGeleverdInGent method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefDatumsGeleverdInGent() {
        System.out.println("Q3. Geef de data waarop geleverd werd bij klant(en) uit GENT (a.d.h.v meerdere geneste subqueries).");

        List<Calendar> result = dl.geefDatumsGeleverdInGent();

        String[] exp = {"8-10-"+vorigJaar, "12-10-"+vorigJaar, "14-10-"+vorigJaar, "21-10-"+vorigJaar, "23-10-"+vorigJaar, "25-10-"+vorigJaar};
        boolean ok;
        for (String s1 : exp) {
            ok = false;
            for (Calendar c : result) {
                if (s1.equals(c.get(Calendar.DAY_OF_MONTH) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR))) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                assertFalse(true);
            }
        }

        assertEquals(exp.length, result.size());
    }

    /**
     * Test of geefTotaleFactuurprijs method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefTotaleFactuurprijs() {
        System.out.println("Q4. Wat is de totale factuurprijs voor de levering(en) van bestellingnummer 1?");

        double result = dl.geefTotaleFactuurprijs();
        assertEquals(30.20, result, 0.01);
    }

    /**
     * Test of geefBestellingenGeleverdBinnen7Dagen method, of class
     * DataLayerJDBC.
     */
    @Test
    public void testGeefBestellingenGeleverdBinnen7Dagen() {
        System.out.println("Q5. Geef de ids en de levertijd van die bestellingen die volledig op minder dan 7 dagen tijd zijn geleverd.");

        List<Integer> result = dl.geefBestellingenGeleverdBinnen7Dagen();
        assertEquals(24, result.size());

        int[] ids = {10, 11, 21, 28, 29, 30};
        for (int id : ids) {
            assertFalse(result.contains(id));
        }
    }
}
