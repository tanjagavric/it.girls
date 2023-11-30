package com.example.platidatisedobrimvrati;

import android.content.Intent;
import android.os.Bundle;

import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;
import com.example.platidatisedobrimvrati.model.OrganizacijaViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {

    public <T> T[] concatenate(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen-3);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 3, c, aLen, bLen-3);

        return c;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        OrganizacijaViewModel mOrganizacijaViewModel = (OrganizacijaViewModel) viewModelProvider.get(OrganizacijaViewModel.class);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button dugmeProba = (Button) findViewById(R.id.dugmeProba);

        dugmeProba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ProbaActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        System.out.println("č");

        Spinner spinner;
        OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(), OrganizacijaRoomDatabase.class, "organizacija_database").allowMainThreadQueries().build();
        OrganizacijaDao dao = db.organizacijaDao();
        String[] imena = dao.getImenaOrganizacija();
        String[] nista = {""};
        String[] imena0 = concatenate(nista, imena);
        Button dugmeOrg1 = (Button) findViewById(R.id.dugmeOrg1);
        Button dugmeOrg2 = (Button) findViewById(R.id.dugmeOrg2);
        Button dugmeOrg3 = (Button) findViewById(R.id.dugmeOrg3);
        Button dugmeNe = (Button) findViewById(R.id.dugmeNe);


        String ime1 = "\"" + imena[0]+"\"";
        String ime2 = "\"" + imena[1]+"\"";
        String ime3 = "\"" + imena[2]+"\"";
        dugmeOrg1.setText(ime1);
        dugmeOrg2.setText(ime2);
        dugmeOrg3.setText(ime3);
        dugmeOrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije = imena[0]; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
        dugmeOrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije = imena[1]; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        dugmeOrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije = imena[2]; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        dugmeNe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.payten.ecr.action");
                intent.setPackage("com.payten.paytenapos");
                int iznosKasa = 1;
                String v = "{\n" +
                        "\t\"header\":{\n" +
                        "\t\t\"length\":64983,\n" +
                        "\t\t\"hash\":\"9397e30d8f92da29d9c1016a3e0eab55c7874f5b1cc67e400ecfac233f82889234f41328b2df08066b3e692dcb6f028d56b0fd009fca18fdac9b5669f6775e71\",\n" +
                        "\t\t\"version\":\"1\"\n" +
                        "\t},\n" +
                        "\t\n" +
                        "\t\"request\":{\t\t\n" +
                        "\t\t\"command\":{\n" +
                        "\t\t\t\"printer\":{\n" +
                        "\t\t\t\t\"type\":\"JSON\",\n" +
                        "\t\t\t\t\"printLines\":\n" +
                        "\t\t\t\t[\n" +
                        "\t\t\t\t\t{\t\"type\":\"QR\",\n" +
                        "\t\t\t\t\t\t\"content\":\"\f d3d3Lmdvb2dsZS5jb20=\"\n" +
                        "\t\t\t\t\t}\n" +
                        "\t\t\t\t]\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "}";
                intent.putExtra("ecrJson", v);
                intent.putExtra("senderIntentFilter", "com.example.platidatisedobrimvrati");
                //intent.putExtra("senderPackage", "com.example.platidatisedobrimvrati");
                //intent.putExtra("senderClass", "MainActivity");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);

                finish();
                System.exit(0);
            }
        });




        //String[] drugeOrganizacije = {"", "ab", "aa", "bb"}; //todo uzeti iz baze kao listu
        // imena svih, ali na 0tu poziciju staviti praznu nisku
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, imena0);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Log.v("item", (String) adapterView.getItemAtPosition(position));
                if (position != 0) {
                    String idOrganizacije = imena0[position];//todo uzima se iz baze
                    Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                    myIntent.putExtra("key", idOrganizacije); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}