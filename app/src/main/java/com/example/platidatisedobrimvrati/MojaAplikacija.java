package com.example.platidatisedobrimvrati;

import android.app.Application;
import android.os.Bundle;

import androidx.room.Room;

import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

public class MojaAplikacija extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
            OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(), OrganizacijaRoomDatabase.class, "organizacija_database").allowMainThreadQueries().build();
            OrganizacijaDao dao = db.organizacijaDao();

            Organizacija organizacija = new Organizacija("Budi Human");
            organizacija.setImeSajta("http://alas.matf.bg.ac.rs/~mm19003/budihuman.html");
            organizacija.setPoruka("Budi Human!");
            organizacija.setLinkDoSlike(R.drawable.budihuman);
            organizacija.setQrCode("aHR0cDovL2FsYXMubWF0Zi5iZy5hYy5ycy9+bW0xOTAwMy9idWRpaHVtYW4uaHRtbA==");
            dao.insert(organizacija);

            organizacija = new Organizacija("Lice Ulice");
            organizacija.setImeSajta("http://alas.matf.bg.ac.rs/~mm19003/liceulice.html");
            organizacija.setPoruka("Podrzi. Doniraj.");
            organizacija.setLinkDoSlike(R.drawable.liceulice);
            organizacija.setQrCode("aHR0cDovL2FsYXMubWF0Zi5iZy5hYy5ycy9+bW0xOTAwMy9saWNldWxpY2UuaHRtbA==");
            dao.insert(organizacija);

            organizacija = new Organizacija("Zvecanska");
            organizacija.setImeSajta("http://alas.matf.bg.ac.rs/~mm19003/zvecanska.html");
            organizacija.setPoruka("Budimo ljudi i pomozimo deci.");
            organizacija.setLinkDoSlike(R.drawable.zvecanska);
            organizacija.setQrCode("aHR0cDovL2FsYXMubWF0Zi5iZy5hYy5ycy9+bW0xOTAwMy96dmVjYW5za2EuaHRtbA==");
            dao.insert(organizacija);

            organizacija = new Organizacija("Felix - azil za mace");
            organizacija.setImeSajta("http://alas.matf.bg.ac.rs/~mm19003/felix.html");
            organizacija.setPoruka("\"Nemoguce je\" rekao je ponos. \"Rizicno je\" reklo je iskustvo. \"Besmisleno je\" rekao je razum. \"Pokusaj\" saputalo je srce.");
            organizacija.setLinkDoSlike(R.drawable.mace);
            organizacija.setQrCode("aHR0cDovL2FsYXMubWF0Zi5iZy5hYy5ycy9+bW0xOTAwMy9mZWxpeC5odG1s");
            dao.insert(organizacija);
    }
}
