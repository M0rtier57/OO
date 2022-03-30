package logica;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * rendement : PortefeuilleTest
 *
 * @author kristien.vanassche
 * @version 28/03/2022
 */
class PortefeuilleTest {
    private Portefeuille portefeuille;

    public PortefeuilleTest() {
        portefeuille = new Portefeuille("Kristien");
    }

    @Test
    public void testConstructor() {
        assertNotNull(portefeuille);
        assertEquals(0, portefeuille.getWaarde());
        assertEquals(0, portefeuille.getOpbrengst());
        assertEquals(0, portefeuille.getInvesteringTotaal());
    }

    @Test
    public void testConstructorNok() {
        assertThrows(IllegalArgumentException.class, () -> new Portefeuille(null));
        assertThrows(IllegalArgumentException.class, () -> new Portefeuille(""));
    }

    private void vulPortefeuille() {
        portefeuille.voegBeleggingToe(new Belegging("Beyond Heat",5000, new double[]{35, -20, 10})); //940€ winst
        portefeuille.voegBeleggingToe(new Belegging("Azanom",5000, new double[] {35,20})); //3100€ winst
        portefeuille.voegBeleggingToe(new Belegging("Snapcat",5000, new double[] {35,-20})); //400€ winst
    }

    @Test
    public void testVoegWaardenToe() {
        vulPortefeuille();
        assertEquals(3, portefeuille.getBeleggingen().size());
    }

    @Test
    public void testWaarden() {
        vulPortefeuille();
        assertEquals(15000, portefeuille.getInvesteringTotaal());
        assertEquals(19440, portefeuille.getWaarde());
        assertEquals(4440, portefeuille.getOpbrengst());
    }

    @Test
    public void testEquals() {
        Belegging b1 = new Belegging("AAA",7500, new double[]{35, -20, 10}); //1410€ winst
        System.out.println(b1.getOpbrengst());
        Belegging b2 = new Belegging("BBB",7500, new double[] {30,8}); // 3030€ winst
        System.out.println(b2.getOpbrengst());
        Portefeuille pf2 = new Portefeuille("KristienBis");
        pf2.voegBeleggingToe(b1); //1410€ winst
        pf2.voegBeleggingToe(b2); //3030€ winst
        System.out.println("Investering portefeuille: " + pf2.getInvesteringTotaal() + "€"); //15000€ totale investering
        System.out.println("Waarde portefeuille: " + pf2.getWaarde() + "€"); //19440€ totale waarde

        assertEquals(15000, pf2.getInvesteringTotaal());
        assertEquals(19440, pf2.getWaarde());
        assertEquals(4440, pf2.getOpbrengst());

        assertNotEquals(portefeuille, pf2);

        vulPortefeuille();
        assertEquals(portefeuille, pf2);

        pf2.voegBeleggingToe(new Belegging("extra", 100));
        assertNotEquals(portefeuille, pf2);
    }

    @Test
    public void testToString() {
        vulPortefeuille();
        System.out.println("Info portefeuille: " + portefeuille);
        ArrayList<Belegging> list = portefeuille.getBeleggingen();
        for (int i = 0; i < portefeuille.getBeleggingen().size(); i++) {
            assertTrue(portefeuille.toString().contains(list.get(i).getMeetkundigRendement() + "%"));
        }
    }
}