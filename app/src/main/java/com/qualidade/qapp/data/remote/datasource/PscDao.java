package com.qualidade.qapp.data.remote.datasource;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.qualidade.qapp.data.models.Psc;

import java.util.List;

@Dao
public interface PscDao {

    @Insert
    public void insert(Psc psc);

    @Update
    public void update(Psc psc);

    @Delete
    public void delete(Psc psc);

    @Query("DELETE FROM notepsc_table")
    void deleteAllPscNotes();

    @Query("SELECT * FROM notepsc_table WHERE date=:date")
    LiveData<List<Psc>> getAllPscNotes(String date);

    @Query("SELECT COUNT(*) FROM notepsc_table")
    LiveData<Integer> getCount_psc_status_total_mes();
    //criar função que pegue o ultimo dia do mês

    @Query("SELECT COUNT(*) FROM notepsc_table WHERE date=:date")
    LiveData<Integer> getCount_psc_status_total_dia(String date);

    @Query("SELECT COUNT(*) FROM notepsc_table WHERE date=:date AND status='NOK'")
    LiveData<Integer> getCount_psc_status_total_dia_nok(String date);
}
