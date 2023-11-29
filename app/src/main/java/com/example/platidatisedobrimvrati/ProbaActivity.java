package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

import java.util.List;

public class ProbaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba);

        OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                OrganizacijaRoomDatabase.class, "baza-organizacija").build();
        OrganizacijaDao organizacijaDao = db.organizacijaDao();
        LiveData<List<Organizacija>> organizacije = organizacijaDao.getListaOrganizacija();
        //Organizacija o1 = new Organizacija("Tina");

        EditText editText = (EditText)findViewById(R.id.editTextText);
        editText.setText(organizacije.toString(), TextView.BufferType.EDITABLE);

    }
}