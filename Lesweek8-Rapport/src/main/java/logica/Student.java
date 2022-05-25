package logica;

import java.util.Objects;

public class Student {
    private String studentnr;
    private String naam;
    private Klasgroep klasgroep;
    private Rapport rapport;

    public Student(String studentnr, String naam, Klasgroep klasgroep) {
        if(studentnr != null && studentnr.charAt(0) == 'r' && studentnr.length() == 8) {
            this.studentnr = studentnr;
        } else {
            throw new IllegalArgumentException("Ongeldig studentennr");
        }
        if(naam != "" && naam != null) {
            this.naam = naam;
        } else {
            throw new IllegalArgumentException("Ongeldige naam");
        }
        if(klasgroep != null) {
            this.klasgroep = klasgroep;
        } else throw new IllegalArgumentException("Ongeldige klasgroep");
        this.rapport = new Rapport();
    }

    public String getStudentnummer() {
        return studentnr;
    }

    public String getNaam() {
        return naam;
    }

    public Klasgroep getKlasgroep() {
        return klasgroep;
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentnr='" + studentnr + '\'' +
                ", naam='" + naam + '\'' +
                ", klasgroep=" + klasgroep.toString() +
                ", rapport=" + rapport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentnr, student.studentnr);
    }
}