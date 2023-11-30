package com.example.platidatisedobrimvrati.model;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "tabela_organizacija")
public class Organizacija {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ime")
    private String ime;
    @ColumnInfo(name = "ime_sajta")
    private String imeSajta;
    @ColumnInfo(name = "poruka")
    private String poruka;
    @ColumnInfo(name = "link_do_slike")
    private int linkDoSlike;
    @ColumnInfo(name = "maksimalna_donacija")
    private double maksimalnaDonacija;
    @ColumnInfo(name = "ukupna_donacija")
    private double ukupnaDonacija;




    public Organizacija(String ime) {
        this.ime = ime;
        this.maksimalnaDonacija=0;
        this.ukupnaDonacija=0;
    }
    public String getIme() {
        return ime;
    }
    public String getImeSajta() {
        return imeSajta;
    }
    public String getPoruka() {
        return poruka;
    }
    public int getLinkDoSlike() { return linkDoSlike; }
    public double getMaksimalnaDonacija() {
        return maksimalnaDonacija;
    }

    public double getUkupnaDonacija() {
        return ukupnaDonacija;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setImeSajta(String imeSajta) {
        this.imeSajta = imeSajta;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public void setLinkDoSlike(int link) { this.linkDoSlike = link; }
    public void setMaksimalnaDonacija(double maksimalnaDonacija) {
        this.maksimalnaDonacija = maksimalnaDonacija;
    }
    public void setUkupnaDonacija(double ukupnaDonacija) {
        this.ukupnaDonacija = ukupnaDonacija;
    }
    public void dodajDonaciju(double iznos) {
        this.ukupnaDonacija+=iznos;
    }

    @Override
    public String toString() {
        return  "ime='" + ime + '\'' +
                ", \nimeSajta='" + imeSajta + '\'' +
                ", \nporuka='" + poruka + '\'' +
                ", \nlinkDoSlike='" + linkDoSlike + '\'' +
                ", \nmaksimalnaDonacija=" + maksimalnaDonacija +
                ", \nukupnaDonacija=" + ukupnaDonacija;
    }


//public Organizacija getOrganizacijaPoImenu
    //napravi metod getOrganizacijaPoImenu
    // napravila get set i atribut linkdoslike
}




