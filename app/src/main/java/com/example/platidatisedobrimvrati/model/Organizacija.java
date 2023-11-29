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
    @ColumnInfo(name = "broj_racuna")
    private long brojRacuna;

    @ColumnInfo(name = "link_do_slike")
    private String linkDoSlike;

    public Organizacija(String ime) {
        this.ime = ime;
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
    public long getBrojRacuna() {
        return brojRacuna;
    }
    public String getLinkDoSlike() { return linkDoSlike; }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setImeSajta(String imeSajta) {
        this.imeSajta = imeSajta;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public void setBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }
    public void setLinkDoSlike(String link) { this.linkDoSlike = link; }

    @Override
    public String toString() {
        return "Organizacija{" +
                "ime='" + ime +
                '}';
    }
    //public Organizacija getOrganizacijaPoImenu
    //napravi metod getOrganizacijaPoImenu
    // napravila get set i atribut linkdoslike
}




