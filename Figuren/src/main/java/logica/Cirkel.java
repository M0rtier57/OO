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
        if(straal < 0) throw new IllegalArgumentException("straal moet groter dan 0 zijn");
        this.straal = straal;
    }

    public Cirkel(double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        super(kleur, kleurRand, dikteRand);
        if(dikteRand < 0) throw new IllegalArgumentException("dikte rand kan niet negatief zijn");
        if(straal < 0) throw new IllegalArgumentException("straal kan niet negatief zijn");
        this.straal = straal;
    }

    public Cirkel(Punt middelpunt, double straal) {
        super();
        if(straal < 0) throw new IllegalArgumentException("straal moet groter dan 0 zijn");
        this.straal = straal;
        super.setMiddelpunt(middelpunt);
    }

    public Cirkel(Punt middelpunt, double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        super(kleur, kleurRand, dikteRand);
        if(dikteRand < 0) throw new IllegalArgumentException("dikte rand kan niet negatief zijn");
        if(straal < 0) throw new IllegalArgumentException("straal moet groter dan 0 zijn");
        this.straal = straal;
        super.setMiddelpunt(middelpunt);
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