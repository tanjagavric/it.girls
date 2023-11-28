package com.example.platidatisedobrimvrati.model;

public class Organizacija {
    private String ime;
    private String imeSajta;

    public Organizacija(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public String getImeSajta() {
        return imeSajta;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setImeSajta(String imeSajta) {
        this.imeSajta = imeSajta;
    }

    @Override
    public String toString() {
        return "Organizacija{" +
                "ime='" + ime + '\'' +
                ", imeSajta='" + imeSajta + '\'' +
                '}';
    }
}




