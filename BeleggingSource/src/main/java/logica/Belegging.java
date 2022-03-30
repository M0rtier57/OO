package logica;

public class Belegging {
    private String naam;
    private int investeringsbedrag;
    private double[] jaarrendementen;

    public Belegging(String naam, int investeringsbedrag, double[] jaarrendementen) {
        if(naam != null && naam != "") {
            this.naam = naam;
        } else {
            throw new IllegalArgumentException("Dit is een ongeldige naam");
        }
        if(investeringsbedrag > 0) {
            this.investeringsbedrag = investeringsbedrag;
        } else {
            throw new IllegalArgumentException("Je kan geen bedrag onder 0 investeren");
        }
        this.jaarrendementen = jaarrendementen;
    }

    public Belegging(String naam, int investeringsbedrag) {
        if(naam != null && naam != "") {
            this.naam = naam;
        } else {
            throw new IllegalArgumentException("Dit is een ongeldige naam");
        }
        if(investeringsbedrag >= 0) {
            this.investeringsbedrag = investeringsbedrag;
        } else {
            throw new IllegalArgumentException("Je kan geen bedrag onder 0 investeren");
        }
    }

    public String getNaam() {
        return this.naam;
    }

    public int getInvesteringsbedrag() {
        return investeringsbedrag;
    }

    public double[] getJaarrendementen() {
        return jaarrendementen;
    }

    public int getWaarde() {
        double waarde = investeringsbedrag;
        double procentvanwaarde;
        for (int i = 0; i < jaarrendementen.length; i++){
            procentvanwaarde = (waarde/100) * jaarrendementen[i];
            waarde = waarde + procentvanwaarde;
        }
        return (int) waarde;
    }

    public int getOpbrengst() {
        return getWaarde() - investeringsbedrag;
    }

    public int getRekenkundigRendement() {
        double som = 0;
        for (int i = 0; i < jaarrendementen.length; i++) {
            som = som + jaarrendementen[i];
        }
        return (int) som;
    }

    public double getMeetkundigRendement(){
        return ((double) getOpbrengst() / investeringsbedrag) * 100;
    }

    public double getGemiddeldRendement() {
        return getMeetkundigRendement() / jaarrendementen.length;
    }

    public double getRendement(Rendement rekenkundig) {
        double rendement = 0;
        switch (rekenkundig) {
            case REKENKUNDIG:
                rendement = (double) getRekenkundigRendement();
                break;
            case MEETKUNDIG:
                rendement = getMeetkundigRendement();
                break;
            case GEMIDDELD:
                rendement = getGemiddeldRendement();
                break;
            default:
                throw new IllegalArgumentException("Dit is geen geldig rendements type.");
        }
        return rendement;
    }

    public void setJaarrendementen(double jaarrendementen[]) {
        this.jaarrendementen = jaarrendementen;
    }

    public void setJaarrendement(double jaarrendement, int jaar) {

    }

    public String toString() {
        return getNaam() + "(" + getMeetkundigRendement() + "% rendement op " + getJaarrendementen().length + ")";
    }

    public boolean equals(Belegging belegging) {
        if(getGemiddeldRendement() == belegging.getGemiddeldRendement()) {
            return true;
        } else {
            return false;
        }
    }
}
