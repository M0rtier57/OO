package logica;

public class Vak {
    public static final int MAX_SCORE = 20;
    private String naam;
    private int stp;
    private int score;

    public Vak(String naam) {
        if(naam == null) {
            throw new IllegalArgumentException("naam is null");
        } else if (naam == "") {
            throw new IllegalArgumentException("Er is geen naam ingevoerd");
        } else {
            this.naam = naam;
        }
    }

    public Vak(String naam,int stp) {
        if(naam == null) {
            throw new IllegalArgumentException("naam is null");
        } else if (naam == "") {
            throw new IllegalArgumentException("Er is geen naam ingevoerd");
        } else {
            this.naam = naam;
        }
        if(stp < 0) {
            throw new IllegalArgumentException("De score is negatief");
        } else {
            this.stp = stp;
        }
    }

    public Vak(Vak vak) {
        this.naam = vak.getNaam();
        this.stp = vak.getStp();
    }

    public String getNaam() {
        return this.naam;
    }

    public int getScore() {
        return this.score;
    }

    public int getStp() {
        return this.stp;
    }

    public void setStp(int stp) {
        this.stp = stp;
    }

    public void setScore(int score) {
        if(score >= 0 && score <= MAX_SCORE) this.score = score;
        else throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
       if (!(o instanceof Vak)) return false;
       return this.naam.equals(((Vak)o).naam);
    }

    public String toString() {
        return this.naam + " (" + this.stp + "stp)";
    }
}
