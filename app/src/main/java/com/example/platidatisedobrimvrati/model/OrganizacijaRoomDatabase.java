package com.example.platidatisedobrimvrati.model;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Organizacija.class}, version = 1, exportSchema = false)
public abstract class OrganizacijaRoomDatabase extends RoomDatabase {

    public abstract OrganizacijaDao organizacijaDao();

    private static volatile OrganizacijaRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static OrganizacijaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (OrganizacijaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    OrganizacijaRoomDatabase.class, "organizacija_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}