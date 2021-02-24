package com.qualidade.qapp.data.remote.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.models.Dod;
import com.qualidade.qapp.data.remote.datasource.DodDao;
import com.qualidade.qapp.data.remote.datasource.DodDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DodRepository {
    private final DodDao dodDao;
    private final LiveData<List<Dod>> allNotesDod;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public DodRepository(Application application) {
        DodDatabase dodDatabase = DodDatabase.getInstance(application);
        dodDao = dodDatabase.noteDaoDOD();
        allNotesDod = dodDao.getAllDodNotes(_date);
    }

    public void insert(Dod dod) { new InsertNoteDodAsyncTask(dodDao).execute(dod); }

    public void delete(Dod dod) { new DeleteNoteDodAsyncTask(dodDao).execute(dod); }

    public void update(Dod dod) { new UpdateNoteDodAsyncTask(dodDao).execute(dod); }

    public void deleteAllNotesDod() { new DeleteAllNoteDodAsyncTask(dodDao).execute(); }

    public LiveData<List<Dod>> getAllNotesDod() { return allNotesDod; }

    private static class InsertNoteDodAsyncTask extends AsyncTask<Dod, Void, Void> {
        private final DodDao dodDao;
        private InsertNoteDodAsyncTask(DodDao dodDao) { this.dodDao = dodDao; }

        @Override
        protected Void doInBackground(Dod... dods) {
            dodDao.insert(dods[0]);
            return null;
        }
    }

    private static class UpdateNoteDodAsyncTask extends AsyncTask<Dod, Void, Void> {
        private final DodDao dodDao;

        private UpdateNoteDodAsyncTask(DodDao dodDao) { this.dodDao = dodDao; }

        @Override
        protected Void doInBackground(Dod... dods) {
            dodDao.update(dods[0]);
            return null;
        }
    }

    private static class DeleteNoteDodAsyncTask extends AsyncTask<Dod, Void, Void> {
        private final DodDao dodDao;

        private DeleteNoteDodAsyncTask(DodDao dodDao) { this.dodDao = dodDao; }

        @Override
        protected Void doInBackground(Dod... dods) {
            dodDao.delete(dods[0]);
            return null;
        }
    }

    private static class DeleteAllNoteDodAsyncTask extends AsyncTask<Dod, Void, Void> {
        private final DodDao dodDao;

        private DeleteAllNoteDodAsyncTask(DodDao dodDao) { this.dodDao = dodDao; }

        @Override
        protected Void doInBackground(Dod... dods) {
            dodDao.deleteAllDodNotes();
            return null;
        }
    }
}
