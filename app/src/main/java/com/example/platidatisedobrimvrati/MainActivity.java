package com.example.platidatisedobrimvrati;

import android.content.Intent;
import android.os.Bundle;

import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;
import com.example.platidatisedobrimvrati.model.OrganizacijaViewModel;
import com.example.platidatisedobrimvrati.model.PlacanjeActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {




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
        Button dugmeOrg1 = (Button) findViewById(R.id.dugmeOrg1);
        Button dugmeOrg2 = (Button) findViewById(R.id.dugmeOrg2);
        Button dugmeOrg3 = (Button) findViewById(R.id.dugmeOrg3);
        Button dugmeNe = (Button) findViewById(R.id.dugmeNe);

        dugmeOrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije="Hello world"; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
        dugmeOrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije="Hello world"; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        dugmeOrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idOrganizacije="Hello world"; //todo uzima se iz baze
                Intent myIntent = new Intent(MainActivity.this, PlacanjeActivity.class);
                myIntent.putExtra("key", idOrganizacije); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        dugmeNe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        Spinner spinner;
        String[] drugeOrganizacije = {"","ab","aa","bb"}; //todo uzeti iz baze kao listu
                                    // imena svih, ali na 0tu poziciju staviti praznu nisku
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,drugeOrganizacije);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Log.v("item", (String) adapterView.getItemAtPosition(position));
                if(position!=0) {
                    String idOrganizacije="Hello world"; //todo uzima se iz baze
                    Intent myIntent = new Intent(MainActivity.this, ProbaActivity2.class);
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