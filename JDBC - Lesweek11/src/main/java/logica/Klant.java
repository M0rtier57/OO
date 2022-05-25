package logica;

import java.util.Date;

public class Klant {
    private int id;
    private String naam;
    private String adres;
    private int postcode;
    private String gemeente;
    private String tel;
    private Date klant_sinds;

    public Klant(int id, String naam, String adres, int postcode, String gemeente, String tel, Date klant_sinds) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.tel = tel;
        this.klant_sinds = klant_sinds;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getKlant_sinds() {
        return klant_sinds;
    }

    public void setKlant_sinds(Date klant_sinds) {
        this.klant_sinds = klant_sinds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
