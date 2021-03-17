package com.qualidade.qapp.data.remote.datasource;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.qualidade.qapp.data.models.Cqm;

import java.util.List;

@Dao
public interface CqmDao {
    @Insert
    public void insert(Cqm cqm);

    @Update
    public void update(Cqm cqm);

    @Query("SELECT * FROM cqm_table WHERE data=:date")
    LiveData<List<Cqm>> getAllCqm(String date);

}
