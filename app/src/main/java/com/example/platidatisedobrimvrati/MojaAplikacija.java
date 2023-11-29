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
            organizacija.setImeSajta("budihuman.com");
            organizacija.setPoruka("Budi Human!");
            organizacija.setLinkDoSlike("res/drawable/budihuman.png");
            dao.insert(organizacija);

            organizacija = new Organizacija("Lice Ulice");
            organizacija.setImeSajta("liceulice.com");
            organizacija.setPoruka("Podrzi. Doniraj.");
            organizacija.setLinkDoSlike("res/drawable/liceulice.png");
            dao.insert(organizacija);

            organizacija = new Organizacija("Zvecanska");
            organizacija.setImeSajta("zvecanska.com");
            organizacija.setPoruka("Hvala!");
            organizacija.setLinkDoSlike("res/drawable/zvecanska.png");
            dao.insert(organizacija);

            organizacija = new Organizacija("Mace");
            organizacija.setImeSajta("kuce.com");
            organizacija.setPoruka("mjau!");
            organizacija.setLinkDoSlike("res/drawable/zvecanska.png");
            dao.insert(organizacija);

            Organizacija o = dao.getOrganizacijaPoImenu("Zvecanska");
            o.setImeSajta("Marija");
            dao.update(o);
    }
}
