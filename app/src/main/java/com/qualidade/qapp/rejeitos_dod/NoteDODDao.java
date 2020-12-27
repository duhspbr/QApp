package com.qualidade.qapp.rejeitos_dod;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Date;
import java.util.List;

@Dao
public interface NoteDODDao {
    @Insert
    public void insert(NoteDOD noteDOD);

    @Update
    public void update(NoteDOD noteDOD);

    @Delete
    public void delete(NoteDOD noteDOD);

    @Query("DELETE FROM notedod_table")
    void deleteAllDodNotes();

    @Query("SELECT * FROM notedod_table WHERE date=:date")
    LiveData<List<NoteDOD>> getAllDodNotes(String date);

    @Query("SELECT COUNT(*) FROM notedod_table WHERE date=:date")
    LiveData<Integer> getCount_psc_status_totay(String date);

    @Query("SELECT COUNT(*) FROM notedod_table")
    LiveData<Integer> getCount();
}
