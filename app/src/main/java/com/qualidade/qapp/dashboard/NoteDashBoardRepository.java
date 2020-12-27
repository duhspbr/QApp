package com.qualidade.qapp.dashboard;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.rejeitos_dod.NoteDODDao;
import com.qualidade.qapp.rejeitos_dod.NoteDODDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class NoteDashBoardRepository {
    private final NoteDODDao noteDashBoardDodDao;
    private final NoteDODDao noteDashBoardPscDao;

    private final LiveData<Integer> allNotesDashBoard;
    private final LiveData<Integer> allNotesDashBoard_psc_status_today;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public NoteDashBoardRepository(Application application) {
        NoteDODDatabase noteDashBoardDodDatabase = NoteDODDatabase.getInstance(application);
        NoteDODDatabase noteDashBoardPscDatabase = NoteDODDatabase.getInstance(application);

        noteDashBoardDodDao = noteDashBoardDodDatabase.noteDaoDOD();
        noteDashBoardPscDao = noteDashBoardPscDatabase.noteDaoDOD();

        allNotesDashBoard = noteDashBoardDodDao.getCount();
        allNotesDashBoard_psc_status_today = noteDashBoardPscDao.getCount_psc_status_totay(_date);
    }

    public LiveData<Integer> getCount() { return noteDashBoardDodDao.getCount(); }

    public LiveData<Integer> getCount_psc_status_totay() { return noteDashBoardPscDao.getCount_psc_status_totay(_date); }

}



//public class NoteDashBoardRepository {
//    private final NoteDODDao noteDashBoardDao;
//    private final LiveData<Integer> allNotesDashBoard;
//
//    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");
//
//    public NoteDashBoardRepository(Application application) {
//        NoteDODDatabase noteDashBoardDatabase = NoteDODDatabase.getInstance(application);
//        noteDashBoardDao = noteDashBoardDatabase.noteDaoDOD();
//        allNotesDashBoard = noteDashBoardDao.getCount(_date);
//    }
//
//    public LiveData<Integer> getCount() { return noteDashBoardDao.getCount(_date); }
//
//}
