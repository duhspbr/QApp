package com.qualidade.qapp.dashboard;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.qualidade.qapp.rejeitos_dod.NoteDOD;
import com.qualidade.qapp.psc_bancario.NotePSC;

import java.util.List;

@Dao
public interface NoteDashBoardDao {

//    @Query("SELECT COUNT(*) FROM notedod_table")
//    LiveData<Integer> getCount();

//    @Query("SELECT COUNT(*) FROM notepsc_table WHERE status='NOK' and date=:date")
//    LiveData<Integer> getCount_psc_status_totay(String date);
}
