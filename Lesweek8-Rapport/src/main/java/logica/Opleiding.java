package logica;

import java.util.ArrayList;
import java.util.List;

public class Opleiding {
    private String naam;
    private List<Student> studenten = new ArrayList<>();

    public Opleiding(String naam) {
        if(naam != null && naam != "") {
            this.naam = naam;
        } else throw new IllegalArgumentException("Ongeldige naam voor de opleiding");
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void voegStudentToe(Student student) {
        if(studenten.contains(student)) {
            studenten.remove(student);
            studenten.add(student);
        } else {
            studenten.add(student);
        }

    }

    public void verwijderStudent(Student student) {
        studenten.remove(student);
    }

    public ArrayList<Student> geefStudentenMetGraad(Graad graad) {
        ArrayList<Student> graadStudenten = new ArrayList<>();
        for(Student s : studenten) {
            if(s.getRapport().geefGraad() == graad) {
                graadStudenten.add(s);
            }
        }
        return graadStudenten;
    }
}
