package com.qualidade.qapp.data.remote.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.remote.datasource.PscDao;
import com.qualidade.qapp.data.remote.datasource.PscDatabase;
import com.qualidade.qapp.data.models.Psc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class PscRepository {
    private final PscDao pscDao;
    private final LiveData<List<Psc>> allNotesPsc;
    public final LiveData<List<Psc>> allClientesAudits;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public PscRepository(Application application) {
        PscDatabase pscDatabase = PscDatabase.getInstance(application);
        pscDao = pscDatabase.notePSCDao();
        allNotesPsc = pscDao.getAllPscNotes(_date);
        allClientesAudits = pscDao.getAllClienteAudits();
    }

    public void insert(Psc psc) { new InsertNotePscAsyncTask(pscDao).execute(psc); }

    public void delete(Psc psc) { new DeleteNotePscAsyncTask(pscDao).execute(psc); }

    public void update(Psc psc) { new UpdateNotePscAsyncTask(pscDao).execute(psc); }

    public void deleteAllNotesPsc() { new DeleteAllNotePscAsyncTask(pscDao).execute(); }

    public LiveData<List<Psc>> getAllNotesPsc() { return allNotesPsc; }

    public LiveData<List<Psc>> getAllClientesAudits(String cliente) { return allClientesAudits; }

    private static class InsertNotePscAsyncTask extends AsyncTask<Psc, Void, Void> {
        private final PscDao pscDao;

        private InsertNotePscAsyncTask(PscDao pscDao) { this.pscDao = pscDao; }

        @Override
        protected Void doInBackground(Psc... pscs) {
            pscDao.insert(pscs[0]);
            return null;
        }
    }

    private static class UpdateNotePscAsyncTask extends AsyncTask<Psc, Void, Void> {
        private final PscDao pscDao;

        private UpdateNotePscAsyncTask(PscDao pscDao) { this.pscDao = pscDao; }

        @Override
        protected Void doInBackground(Psc... pscs) {
            pscDao.update(pscs[0]);
            return null;
        }
    }

    private static class DeleteNotePscAsyncTask extends AsyncTask<Psc, Void, Void> {
        private final PscDao pscDao;

        private DeleteNotePscAsyncTask(PscDao pscDao) { this.pscDao = pscDao; }

        @Override
        protected Void doInBackground(Psc... pscs) {
            pscDao.delete(pscs[0]);
            return null;
        }
    }

    private static class DeleteAllNotePscAsyncTask extends AsyncTask<Psc, Void, Void> {
        private final PscDao pscDao;

        private DeleteAllNotePscAsyncTask(PscDao pscDao) { this.pscDao = pscDao; }

        @Override
        protected Void doInBackground(Psc... pscs) {
            pscDao.deleteAllPscNotes();
            return null;
        }
    }
}
