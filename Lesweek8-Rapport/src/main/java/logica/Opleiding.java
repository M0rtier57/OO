package logica;

import java.util.List;

public class Opleiding {
    private String naam;
    private List<Student> studenten;

    public Opleiding(String naam) {
        this.naam = naam;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void voegStudentToe(Student student) {
        this.studenten.add(student);
    }

    public void verwijderStudent(Student student) {
        this.studenten.remove(student);
    }
}
