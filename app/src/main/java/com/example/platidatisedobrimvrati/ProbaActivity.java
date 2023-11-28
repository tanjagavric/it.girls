package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ProbaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba);

        EditText editText = (EditText)findViewById(R.id.editTextText);
        editText.setText("This sets the text.", TextView.BufferType.EDITABLE);

    }
}