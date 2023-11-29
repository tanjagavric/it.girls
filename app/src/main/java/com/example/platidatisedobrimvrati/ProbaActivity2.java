package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ProbaActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba2);

        String idOrganizacije = new String("a");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           idOrganizacije = extras.getString("key");
            //The key argument here must match that used in the other activity
        }


        EditText editText = (EditText)findViewById(R.id.editText2);
        editText.setText(idOrganizacije, TextView.BufferType.EDITABLE);
    }
}