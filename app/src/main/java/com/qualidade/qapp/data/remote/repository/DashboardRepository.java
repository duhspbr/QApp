package com.qualidade.qapp.data.remote.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.remote.datasource.PscDao;
import com.qualidade.qapp.data.remote.datasource.PscDatabase;
import com.qualidade.qapp.data.remote.datasource.DodDao;
import com.qualidade.qapp.data.remote.datasource.DodDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DashboardRepository {
    private final DodDao noteDashBoardDodDao;
    private final PscDao noteDashBoardPscDao;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public DashboardRepository(Application application) {
        DodDatabase noteDashBoardDodDatabase = DodDatabase.getInstance(application);
        PscDatabase noteDashBoardPscDatabase = PscDatabase.getInstance(application);

        noteDashBoardDodDao = noteDashBoardDodDatabase.noteDaoDOD();
        noteDashBoardPscDao = noteDashBoardPscDatabase.notePSCDao();

    }

    public LiveData<Integer> getCount() { return noteDashBoardDodDao.getCount(); }

    public LiveData<Integer> getCount_psc_status_hoje() { return noteDashBoardPscDao.getCount_psc_status_total_dia(_date); }

    public LiveData<Integer> getCount_psc_status_total_dia_nok() { return noteDashBoardPscDao.getCount_psc_status_total_dia_nok(_date); }

    public LiveData<Integer> getCount_dod_gav1() { return noteDashBoardDodDao.getCount_dod_gav1(_date); }

    public LiveData<Integer> getCount_dod_gav2() { return noteDashBoardDodDao.getCount_dod_gav2(_date); }

    public LiveData<Integer> getCount_dod_entrada() { return noteDashBoardDodDao.getCount_dod_entrada(_date); }

    public LiveData<Integer> getCount_dod_saida() { return noteDashBoardDodDao.getCount_dod_saida(_date); }
}