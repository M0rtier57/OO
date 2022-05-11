package logica;

public class Cirkel {
    private double straal;

    public Cirkel() {
        this.straal = 50.0;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return straal * 2 * Math.PI;
            }

            @Override
            public double berekenOppervlakte() {
                return straal * straal * Math.PI;
            }
        };
    }

    public Cirkel(double straal) {
        this.straal = straal;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return straal * 2 * Math.PI;
            }

            @Override
            public double berekenOppervlakte() {
                return straal * straal * Math.PI;
            }
        };
    }

    public Cirkel(double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.straal = straal;
        Figuur cirkel = new Figuur(kleur, kleurRand, dikteRand) {
            @Override
            public double berekenOmtrek() {
                return straal * 2 * Math.PI;
            }

            @Override
            public double berekenOppervlakte() {
                return straal * straal * Math.PI;
            }
        };
    }

    public Cirkel(Punt middelpunt, double straal) {
        this.straal = straal;
        Figuur cirkel = new Figuur() {
            @Override
            public double berekenOmtrek() {
                return straal * 2 * Math.PI;
            }

            @Override
            public double berekenOppervlakte() {
                return straal * straal * Math.PI;
            }
        };
        cirkel.setMiddelpunt(middelpunt);
    }

    public Cirkel(Punt middelpunt, double straal, Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.straal = straal;
        Figuur cirkel = new Figuur(kleur, kleurRand, dikteRand) {
            @Override
            public double berekenOmtrek() {
                return straal * 2 * Math.PI;
            }

            @Override
            public double berekenOppervlakte() {
                return straal * straal * Math.PI;
            }
        };
        cirkel.setMiddelpunt(middelpunt);
    }

    public double getStraal() {
        return straal;
    }
}