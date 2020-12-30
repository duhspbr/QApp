package com.qualidade.qapp.psc_bancario;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Dao
public interface NotePSCDao {

    @Insert
    public void insert(NotePSC notePSC);

    @Update
    public void update(NotePSC notePSC);

    @Delete
    public void delete(NotePSC notePSC);

    @Query("DELETE FROM notepsc_table")
    void deleteAllPscNotes();

    @Query("SELECT * FROM notepsc_table WHERE date=:date")
    LiveData<List<NotePSC>> getAllPscNotes(String date);

    @Query("SELECT COUNT(*) FROM notepsc_table")
    LiveData<Integer> getCount_psc_status_total_mes();
    //criar função que pegue o ultimo dia do mês

    @Query("SELECT COUNT(*) FROM notepsc_table WHERE date=:date")
    LiveData<Integer> getCount_psc_status_total_dia(String date);

    @Query("SELECT COUNT(*) FROM notepsc_table WHERE date=:date AND status='NOK'")
    LiveData<Integer> getCount_psc_status_total_dia_nok(String date);
}
