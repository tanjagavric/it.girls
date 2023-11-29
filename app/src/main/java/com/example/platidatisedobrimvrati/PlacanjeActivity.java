package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.platidatisedobrimvrati.R;

public class PlacanjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placanje);

        Button dugmePlati = (Button)findViewById(R.id.dugmePlatiSvotu);
        Button dugmeSvota1 = (Button)findViewById(R.id.dugmeSvota1);
        Button dugmeSvota2 = (Button)findViewById(R.id.dugmeSvota2);
        Button dugmeSvota3 = (Button)findViewById(R.id.dugmeSvota3);
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
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