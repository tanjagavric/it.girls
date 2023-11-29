package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;
import com.example.platidatisedobrimvrati.model.OrganizacijaViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ProbaActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private OrganizacijaViewModel mOrganizacijaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final OrganizacijaListAdapter adapter = new OrganizacijaListAdapter(new OrganizacijaListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mOrganizacijaViewModel = new ViewModelProvider(this).get(OrganizacijaViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mOrganizacijaViewModel.getListaOrganizacija().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ProbaActivity.this, MainActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });


        OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(), OrganizacijaRoomDatabase.class, "organizacija_database").allowMainThreadQueries().build();
        OrganizacijaDao dao = db.organizacijaDao();
        Organizacija irina = new Organizacija("Irina");
        dao.insert(irina);
        Organizacija o = dao.getOrganizacijaPoImenu("Tanja");

        EditText editText = (EditText)findViewById(R.id.editTextText);
        editText.setText(o.toString(), TextView.BufferType.EDITABLE);

    }
}