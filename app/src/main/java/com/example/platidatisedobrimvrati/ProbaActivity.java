package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.platidatisedobrimvrati.model.Organizacija;

public class ProbaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba);

        Organizacija o1 = new Organizacija("Tina");

        EditText editText = (EditText)findViewById(R.id.editTextText);
        editText.setText(o1.getIme(), TextView.BufferType.EDITABLE);

    }
}