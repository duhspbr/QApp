package com.qualidade.qapp.data.remote.datasource;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.qualidade.qapp.data.models.Dod;

import java.util.List;

@Dao
public interface DodDao {
    @Insert
    public void insert(Dod dod);

    @Update
    public void update(Dod dod);

    @Delete
    public void delete(Dod dod);

    @Query("DELETE FROM notedod_table")
    void deleteAllDodNotes();

    @Query("SELECT * FROM notedod_table WHERE date=:date")
    LiveData<List<Dod>> getAllDodNotes(String date);

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date")
    LiveData<Integer> getCount_psc_status_totay(String date);

    @Query("SELECT COUNT(*) FROM notedod_table")
    LiveData<Integer> getCount();

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date AND gaveta='GAV 1'")
    LiveData<Integer> getCount_dod_gav1(String date);

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date AND gaveta='GAV 2'")
    LiveData<Integer> getCount_dod_gav2(String date);

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date AND gaveta='PACK ENTRADA'")
    LiveData<Integer> getCount_dod_entrada(String date);

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date AND gaveta='PACK SAIDA'")
    LiveData<Integer> getCount_dod_saida(String date);
}
