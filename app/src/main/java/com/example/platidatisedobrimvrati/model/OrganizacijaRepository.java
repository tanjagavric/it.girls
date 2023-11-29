package com.example.platidatisedobrimvrati.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class OrganizacijaRepository {

    private OrganizacijaDao mOrganizacijaDao;
    private LiveData<List<Organizacija>> mListaOrganizacija;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    OrganizacijaRepository(Application application) {
        OrganizacijaRoomDatabase db = OrganizacijaRoomDatabase.getDatabase(application);
        mOrganizacijaDao = db.organizacijaDao();
        mListaOrganizacija = mOrganizacijaDao.getListaOrganizacija();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Organizacija>> getListaOrganizacija() {
        return mListaOrganizacija;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Organizacija organizacija) {
        OrganizacijaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mOrganizacijaDao.insert(organizacija);
        });
    }
}
