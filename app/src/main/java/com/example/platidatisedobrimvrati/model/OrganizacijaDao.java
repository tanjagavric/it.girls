package com.example.platidatisedobrimvrati.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

//data access object
@Dao
public interface OrganizacijaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Organizacija organizacija);

    @Query("DELETE FROM tabela_organizacija")
    void deleteAll();

    @Query("SELECT * FROM tabela_organizacija")
    LiveData<List<Organizacija>> getListaOrganizacija();

    @Query("SELECT * FROM tabela_organizacija WHERE ime = :imeOrg")
    Organizacija getOrganizacijaPoImenu(String imeOrg);
}
