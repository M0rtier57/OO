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
        this.score = score;
    }

    public boolean equals(Vak vak) {
       if(this.naam.compareTo(vak.getNaam()) == 0) {
           return true;
       } else {
           return false;
       }
    }

    public String toString() {
        return this.naam + " (" + this.stp + "stp)";
    }
}
