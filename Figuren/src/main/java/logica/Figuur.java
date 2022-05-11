package logica;

import java.util.Objects;

abstract public class Figuur {
    Kleur kleur;
    Kleur kleurRand;
    int dikteRand;
    Punt middelpunt;

    public Figuur() {
        this.kleur = Kleur.WIT;
        this.middelpunt = new Punt(0,0);
        this.kleurRand = Kleur.ZWART;
        this.dikteRand = 1;
    }

    public Figuur(Kleur kleur, Kleur kleurRand, int dikteRand) {
        this.kleur = kleur;
        this.middelpunt = new Punt(0,0);
        this.kleurRand = kleurRand;
        this.dikteRand = dikteRand;
    }

    public double berekenAfstand(Figuur figuur) {
        double a = Math.pow(figuur.middelpunt.getX() - this.middelpunt.getX(), 2);
        double b = Math.pow(figuur.middelpunt.getY() - this.middelpunt.getY(), 2);
        return Math.sqrt(a + b);
    }

    public double berekenAfstand(Punt punt) {
        double a = Math.pow(punt.getX() - this.middelpunt.getX(), 2);
        double b = Math.pow(punt.getY() - this.middelpunt.getY(), 2);
        return Math.sqrt(a + b);
    }

    abstract public double berekenOmtrek();

    abstract public double berekenOppervlakte();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figuur figuur = (Figuur) o;
        return dikteRand == figuur.dikteRand && kleur == figuur.kleur && kleurRand == figuur.kleurRand && Objects.equals(middelpunt, figuur.middelpunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, kleurRand, dikteRand, middelpunt);
    }

    public int getDikteRand() {
        return dikteRand;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public Kleur getKleurRand() {
        return kleurRand;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public void setMiddelpunt(Punt middelpunt) {
        this.middelpunt = middelpunt;
    }

    @Override
    public String toString() {
        return "Figuur{" +
                "kleur=" + kleur +
                ", kleurRand=" + kleurRand +
                ", dikteRand=" + dikteRand +
                ", middelpunt=" + middelpunt +
                '}';
    }
}
