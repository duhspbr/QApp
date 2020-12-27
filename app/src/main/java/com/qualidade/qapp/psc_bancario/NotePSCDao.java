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
}
