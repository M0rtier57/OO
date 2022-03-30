package logica;

public class Belegging {
    private String naam;
    private int investeringsbedrag;
    private double[] jaarrendementen;

    public Belegging(String naam, int investeringsbedrag, double[] jaarrendementen) {
        this.naam = naam;
        if(investeringsbedrag >= 0) {
            this.investeringsbedrag = investeringsbedrag;
        } else {
            new IllegalArgumentException("Je kan geen bedrag onder 0 investeren");
        }
        this.jaarrendementen = jaarrendementen;
    }

    public Belegging(String naam, int investeringsbedrag) {
        this.naam = naam;
        if(investeringsbedrag >= 0) {
            this.investeringsbedrag = investeringsbedrag;
        } else {
            new IllegalArgumentException("Je kan geen bedrag onder 0 investeren");
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
            waarde = (waarde + procentvanwaarde);
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

    public int getMeetkundigRendement(){
        return 0;
    }

    public int getGemiddeldRendement() {
        return jaarrendementen.length/getMeetkundigRendement();
    }

    public int getRendement(Rendement rekenkundig) {
        return 0;
    }

    public void setJaarrendementen(double jaarrendementen[]) {

    }

    public void setJaarrendement(double jaarrendementen, int jaar) {

    }
}
