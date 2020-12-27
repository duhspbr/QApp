package com.qualidade.qapp.psc_bancario;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class NotePSCRepository {
    private final NotePSCDao notePSCDao;
    private final LiveData<List<NotePSC>> allNotesPsc;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public NotePSCRepository(Application application) {
        NotePSCDatabase notePSCDatabase = NotePSCDatabase.getInstance(application);
        notePSCDao = notePSCDatabase.notePSCDao();
        allNotesPsc = notePSCDao.getAllPscNotes(_date);
    }

    public void insert(NotePSC notePSC) { new InsertNotePscAsyncTask(notePSCDao).execute(notePSC); }

    public void delete(NotePSC notePSC) { new DeleteNotePscAsyncTask(notePSCDao).execute(notePSC); }

    public void update(NotePSC notePSC) { new UpdateNotePscAsyncTask(notePSCDao).execute(notePSC); }

    public void deleteAllNotesPsc() { new DeleteAllNotePscAsyncTask(notePSCDao).execute(); }

    public LiveData<List<NotePSC>> getAllNotesPsc() { return allNotesPsc; }

    private static class InsertNotePscAsyncTask extends AsyncTask<NotePSC, Void, Void> {
        private final NotePSCDao notePSCDao;

        private InsertNotePscAsyncTask(NotePSCDao notePscDao) { this.notePSCDao = notePscDao; }

        @Override
        protected Void doInBackground(NotePSC... notePSCS) {
            notePSCDao.insert(notePSCS[0]);
            return null;
        }
    }

    private static class UpdateNotePscAsyncTask extends AsyncTask<NotePSC, Void, Void> {
        private final NotePSCDao notePSCDao;

        private UpdateNotePscAsyncTask(NotePSCDao notePSCDao) { this.notePSCDao = notePSCDao; }

        @Override
        protected Void doInBackground(NotePSC... notePSCS) {
            notePSCDao.update(notePSCS[0]);
            return null;
        }
    }

    private static class DeleteNotePscAsyncTask extends AsyncTask<NotePSC, Void, Void> {
        private final NotePSCDao notePSCDao;

        private DeleteNotePscAsyncTask(NotePSCDao notePSCDao) { this.notePSCDao = notePSCDao; }

        @Override
        protected Void doInBackground(NotePSC... notePSCS) {
            notePSCDao.delete(notePSCS[0]);
            return null;
        }
    }

    private static class DeleteAllNotePscAsyncTask extends AsyncTask<NotePSC, Void, Void> {
        private final NotePSCDao notePSCDao;

        private DeleteAllNotePscAsyncTask(NotePSCDao notePSCDao) { this.notePSCDao = notePSCDao; }

        @Override
        protected Void doInBackground(NotePSC... notePSCS) {
            notePSCDao.deleteAllPscNotes();
            return null;
        }
    }
}
