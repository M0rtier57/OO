package logica;

import java.util.Objects;

public class Cirkel {
    private double straal;

    public Cirkel() {
        this.straal = 50.0;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return Cirkel.this.berekenOmtrek();
            }

            @Override
            public double berekenOppervlakte() {
                return Cirkel.this.berekenOppervlakte();
            }
        };
    }

    public Cirkel(double straal) {
        this.straal = straal;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return Cirkel.this.berekenOmtrek();
            }

            @Override
            public double berekenOppervlakte() {
                return Cirkel.this.berekenOppervlakte();
            }
        };
    }

    public Cirkel(double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.straal = straal;
        Figuur cirkel = new Figuur(kleur, kleurRand, dikteRand) {
            @Override
            public double berekenOmtrek() {
                return Cirkel.this.berekenOmtrek();
            }

            @Override
            public double berekenOppervlakte() {
                return Cirkel.this.berekenOppervlakte();
            }
        };
    }

    public Cirkel(Punt middelpunt, double straal) {
        this.straal = straal;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return Cirkel.this.berekenOmtrek();
            }

            @Override
            public double berekenOppervlakte() {
                return Cirkel.this.berekenOppervlakte();
            }
        };
        cirkel.setMiddelpunt(middelpunt);
    }

    public Cirkel(Punt middelpunt, double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.straal = straal;
        Figuur cirkel = new Figuur(kleur, kleurRand, dikteRand) {
            @Override
            public double berekenOmtrek() {
                return Cirkel.this.berekenOmtrek();
            }

            @Override
            public double berekenOppervlakte() {
                return Cirkel.this.berekenOppervlakte();
            }
        };
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        return Double.compare(cirkel.straal, straal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(straal);
    }
}