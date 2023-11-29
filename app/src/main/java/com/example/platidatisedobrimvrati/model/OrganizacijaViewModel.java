package com.example.platidatisedobrimvrati.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class OrganizacijaViewModel extends AndroidViewModel {

    private OrganizacijaRepository mRepository;

    private final LiveData<List<Organizacija>> mListaOrganizacija;

    public OrganizacijaViewModel (Application application) {
        super(application);
        mRepository = new OrganizacijaRepository(application);
        mListaOrganizacija = mRepository.getListaOrganizacija();
    }

    LiveData<List<Organizacija>> getListaOrganizacija() { return mListaOrganizacija; }

    public void insert(Organizacija organizacija) { mRepository.insert(organizacija); }
}