/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.logica;

/**
 *
 * @author evertjan.jacobs
 */
public class Artikel {

    private int id;
    private String beschrijving;

    public Artikel(int id, String beschrijving) {
        this.id = id;
        this.beschrijving = beschrijving;
    }

    @Override
    public String toString() {
        return "Artikel{" + "id=" + id + ", beschrijving=" + beschrijving + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Artikel) {
            return ((Artikel) obj).id == this.id;
        }
        return false;
    }
}
