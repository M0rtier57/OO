package logica;

import java.util.Objects;

public class Cirkel extends Figuur {
    private double straal;

    public Cirkel() {
        super();
        this.straal = 50.0;
    }

    public Cirkel(double straal) {
        super();
        this.straal = straal;
    }

    public Cirkel(double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        super(kleur, kleurRand, dikteRand);
        this.straal = straal;
    }

    public Cirkel(Punt middelpunt, double straal) {
        this.straal = straal;
        Figuur cirkel = new Figuur();
        cirkel.setMiddelpunt(middelpunt);
    }

    public Cirkel(Punt middelpunt, double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.straal = straal;
        Figuur cirkel = new Figuur(kleur, kleurRand, dikteRand);
        cirkel.setMiddelpunt(middelpunt);
    }

    public double getStraal() {
        return straal;
    }

    public double berekenOmtrek() {
        return this.straal * 2 * Math.PI;
    }

    public double berekenOppervlakte() {
        return this.straal * this.straal * Math.PI;
    }

    @Override
    public String toString() {
        return "Cirkel{" +
                "straal=" + straal +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        if(this.straal == cirkel.straal && super.equals(cirkel)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(straal);
    }
}