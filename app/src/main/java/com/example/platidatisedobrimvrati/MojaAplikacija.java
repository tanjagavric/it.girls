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
            organizacija.setImeSajta("budihuman.rs");
            organizacija.setPoruka("Budi Human!");
            organizacija.setLinkDoSlike(R.drawable.budihuman);
            dao.insert(organizacija);

            organizacija = new Organizacija("Lice Ulice");
            organizacija.setImeSajta("liceulice.org");
            organizacija.setPoruka("Podrzi. Doniraj.");
            organizacija.setLinkDoSlike(R.drawable.liceulice);
            dao.insert(organizacija);

            organizacija = new Organizacija("Zvecanska");
            organizacija.setImeSajta("zvecanska.org.rs");
            organizacija.setPoruka("Hvala!");
            organizacija.setLinkDoSlike(R.drawable.zvecanska);
            dao.insert(organizacija);

            organizacija = new Organizacija("Felix - azil za mace");
            organizacija.setImeSajta("felix-catshelter.com");
            organizacija.setPoruka("mjau!");
            organizacija.setLinkDoSlike(R.drawable.mace);
            dao.insert(organizacija);

            Organizacija o = dao.getOrganizacijaPoImenu("Zvecanska");
            o.setImeSajta("Marija");
            dao.update(o);
    }
}
