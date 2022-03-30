package logica;

import java.util.ArrayList;

public class Portefeuille {
    private String naam;
    private ArrayList<Belegging> beleggingen;

    public Portefeuille(String naam) {
        if(naam != null && naam != "") {
            this.naam = naam;
        } else {
            throw new IllegalArgumentException("ongeldige naam");
        }

    }

    public ArrayList<Belegging> getBeleggingen() {
        return beleggingen;
    }

    public void voegBeleggingToe(Belegging belegging) {
        this.beleggingen.add(belegging);
    }

    public double getInvesteringTotaal() {
        return 0;
    }

    public double getOpbrengst() {
        return 0;
    }

    public double getWaarde() {
        return 0;
    }
}
