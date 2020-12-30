package com.qualidade.qapp.dashboard;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.psc_bancario.NotePSC;
import com.qualidade.qapp.psc_bancario.NotePSCDao;
import com.qualidade.qapp.psc_bancario.NotePSCDatabase;
import com.qualidade.qapp.rejeitos_dod.NoteDODDao;
import com.qualidade.qapp.rejeitos_dod.NoteDODDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class NoteDashBoardRepository {
    private final NoteDODDao noteDashBoardDodDao;
    private final NotePSCDao noteDashBoardPscDao;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public NoteDashBoardRepository(Application application) {
        NoteDODDatabase noteDashBoardDodDatabase = NoteDODDatabase.getInstance(application);
        NotePSCDatabase noteDashBoardPscDatabase = NotePSCDatabase.getInstance(application);

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