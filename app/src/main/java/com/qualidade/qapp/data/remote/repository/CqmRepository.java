package com.qualidade.qapp.data.remote.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.models.Cqm;
import com.qualidade.qapp.data.models.Login;
import com.qualidade.qapp.data.remote.datasource.CqmDao;
import com.qualidade.qapp.data.remote.datasource.CqmDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CqmRepository {
    private final CqmDao cqmDao;
    private final LiveData<List<Cqm>> allCqm;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public CqmRepository(Application application) {
        CqmDatabase cqmDatabase = CqmDatabase.getInstance(application);
        cqmDao = cqmDatabase.cqmDao();
        allCqm = cqmDao.getAllCqm(_date);
    }

    public void insert(Cqm cqm) { new InsertCqmAsyncTask(cqmDao).execute(cqm); }
    public LiveData<List<Cqm>> getAllCqm() { return allCqm; }

    public static class InsertCqmAsyncTask extends AsyncTask<Cqm, Void, Void> {
        private final CqmDao cqmDao;
        private InsertCqmAsyncTask(CqmDao cqmDao) { this.cqmDao = cqmDao; }

        @Override
        protected Void doInBackground(Cqm... cqms) {
            cqmDao.insert(cqms[0]);
            return null;
        }
    }
}
