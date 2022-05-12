package logica;

import java.util.Objects;

public class Vierkant extends Figuur {
    private double zijde;

    public Vierkant() {
        super();
        this.zijde = 50.0;
    }

    public Vierkant(double zijde) {
        super();
        if(zijde < 0) throw new IllegalArgumentException("zijde moet groter dan 0 zijn");
        this.zijde = zijde;
    }

    public Vierkant(double zijde, Kleur kleur, Kleur kleurRand, int dikteRand) {
        super(kleur, kleurRand, dikteRand);
        if(dikteRand < 0) throw new IllegalArgumentException("dikte rand kan niet negatief zijn");
        if(zijde < 0) throw new IllegalArgumentException("zijde kan niet negatief zijn");
        this.zijde = zijde;
    }

    public Vierkant(Punt middelpunt, double zijde) {
        super();
        if(zijde < 0) throw new IllegalArgumentException("zijde moet groter dan 0 zijn");
        this.zijde = zijde;
        super.setMiddelpunt(middelpunt);
    }

    public Vierkant(Punt middelpunt, double zijde, Kleur kleur, Kleur kleurRand, int dikteRand) {
        super(kleur, kleurRand, dikteRand);
        if(dikteRand < 0) throw new IllegalArgumentException("dikte rand kan niet negatief zijn");
        if(zijde < 0) throw new IllegalArgumentException("zijde moet groter dan 0 zijn");
        this.zijde = zijde;
        super.setMiddelpunt(middelpunt);
    }

    public double getZijde() {
        return zijde;
    }

    public double berekenOmtrek() {
        return this.zijde * 4;
    }

    public double berekenOppervlakte() {
        return this.zijde * this.zijde;
    }

    @Override
    public String toString() {
        return "Vierkant{" +
                "zijde=" + zijde +
                "cm }" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vierkant vierkant = (Vierkant) o;
        if(this.zijde == vierkant.zijde && super.equals(vierkant)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zijde);
    }
}
