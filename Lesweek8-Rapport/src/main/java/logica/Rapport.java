package logica;

public class Rapport {
    private Vak[] vakken;

    public Rapport(Vak[] vakken) { this.vakken = vakken;}

    public Vak[] getVakken() {
        return this.vakken;
    }

    public double geefGewogenResultaatProcent() {
        int totaal = 0;
        int totaalstp = 0;

        for(int i = 0; i < this.vakken.length; i++) {
            totaal = totaal + (vakken[i].getScore() * (vakken[i].getStp()));
            totaalstp = totaalstp + (vakken[i].getStp());
        }

        double procent = (totaal/(double)totaalstp) * 5;
        return Helper.afronden(procent, 2);
    }

    public Graad geefGraad() {
        if(geefGewogenResultaatProcent() < 0 || geefGewogenResultaatProcent() > 100) throw new IllegalArgumentException("ongeldig resultaat");
        if(geefGewogenResultaatProcent() < 50) return Graad.NIET_GESLAAGD;
        if (geefGewogenResultaatProcent() < 65) return Graad.VOLDOENING;
        if (geefGewogenResultaatProcent() < 75) return Graad.ONDERSCHEIDING;
        if (geefGewogenResultaatProcent() < 85) return Graad.GROTE_ONDERSCHEIDING;
        else return Graad.GROOTSTE_ONDERSCHEIDING;
    }

    public String toString() {
        return "" + Helper.afronden(geefGewogenResultaatProcent(), 1) + "% - " + geefGraad().toString().replace('_', ' ');
    }

    private boolean alleVakkenGeslaagd() {
        int vakkengeslaagd = 0;
        for (int i = 0; i < vakken.length; i++) if(vakken[i].getScore() > 10) vakkengeslaagd++;
        if(vakkengeslaagd == vakken.length) return true;
        else return false;
    }
}
