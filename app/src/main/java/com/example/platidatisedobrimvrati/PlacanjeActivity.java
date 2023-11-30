package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.platidatisedobrimvrati.R;
import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

import java.io.File;

public class PlacanjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placanje);

        String imeOrganizacije = new String("a");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            imeOrganizacije = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        Button dugmePlati = (Button)findViewById(R.id.dugmePlatiSvotu);
        Button dugmeSvota1 = (Button)findViewById(R.id.dugmeSvota1);
        Button dugmeSvota2 = (Button)findViewById(R.id.dugmeSvota2);
        Button dugmeSvota3 = (Button)findViewById(R.id.dugmeSvota3);
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        TextView tvZahvalnica = (TextView)findViewById(R.id.tvZahvalnica);
        int c = R.drawable.budihuman;

        OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(), OrganizacijaRoomDatabase.class, "organizacija_database").allowMainThreadQueries().build();
        OrganizacijaDao dao = db.organizacijaDao();
        Organizacija org = dao.getOrganizacijaPoImenu(imeOrganizacije);
        int linkDoSlike = org.getLinkDoSlike();

        ImageView ivSlika=(ImageView)findViewById(R.id.imageView);
        ivSlika.setImageResource(linkDoSlike);

        String textZahvalnice = "Donirajte za organizaciju:\n\"" + imeOrganizacije+"\"";
        tvZahvalnica.setText(textZahvalnice);
        //tvZahvalnica.setTextAlignment();
        dugmePlati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //todo funkcionalnost placanja na posu
            }
        });

        dugmeSvota1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = (String)dugmeSvota1.getText();
                String []arrOfStr = text1.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);

            }
        });
        dugmeSvota2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = (String)dugmeSvota2.getText();
                String []arrOfStr = text2.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);
            }
        });

        dugmeSvota3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text3 = (String)dugmeSvota3.getText();
                String []arrOfStr = text3.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);
            }
        });

    }


}