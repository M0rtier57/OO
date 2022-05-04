/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.data;

/**
 *
 * @author evertjan.jacobs
 */
public class Configuratie {

    //Q1. Geef voor elke bestelling: het bestelnummer en de prijs van het duurste artikel die hierbij besteld werd(en).
    public static String QUERY_DUURSTE_ARTIKEL_PER_BESTELLING = "";

    //Q2. Geef het artikelnummer én de beschrijving van alle artikelen waarvan er meer dan 4 eenheden besteld geweest zijn, en dit verspreid over minstens 2 leveringen. Je hoeft geen rekening te houden met bestellingen die nog niet geleverd zijn.
    public static String QUERY_ARTIKELEN_MIN_4_BESTELD_VERSPREID_OVER_MEERDERE_LEVERINGEN = "";

    //Q3. Geef de data waarop geleverd werd bij klant(en) uit GENT (a.d.h.v meerdere geneste subqueries).
    public static String QUERY_DATA_LEVERING_KLANTEN_GENT = "";

    //Q4. Wat is de totale factuurprijs voor de levering(en) van bestellingnummer 1?
    public static String QUERY_TOTALE_PRIJS_BESTELLING_1 = "";

    //Q5. Geef de ids en de levertijd van de bestellingen die volledig op minder dan 7 dagen tijd zijn geleverd.
    public static String QUERY_LEVERING_IN_MINDER_DAN_7_DAGEN = "";
}
