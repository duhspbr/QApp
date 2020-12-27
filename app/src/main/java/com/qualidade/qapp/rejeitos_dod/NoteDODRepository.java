package com.qualidade.qapp.rejeitos_dod;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class NoteDODRepository {
    private final NoteDODDao noteDODDao;
    private final LiveData<List<NoteDOD>> allNotesDod;

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String _date = dateFormat.format(calendar.getTime()).replace("-", "/");

    public NoteDODRepository(Application application) {
        NoteDODDatabase noteDODDatabase = NoteDODDatabase.getInstance(application);
        noteDODDao = noteDODDatabase.noteDaoDOD();
        allNotesDod = noteDODDao.getAllDodNotes(_date);
    }

    public void insert(NoteDOD noteDOD) { new InsertNoteDodAsyncTask(noteDODDao).execute(noteDOD); }

    public void delete(NoteDOD noteDOD) { new DeleteNoteDodAsyncTask(noteDODDao).execute(noteDOD); }

    public void update(NoteDOD noteDOD) { new UpdateNoteDodAsyncTask(noteDODDao).execute(noteDOD); }

    public void deleteAllNotesDod() { new DeleteAllNoteDodAsyncTask(noteDODDao).execute(); }

    public LiveData<List<NoteDOD>> getAllNotesDod() { return allNotesDod; }

    private static class InsertNoteDodAsyncTask extends AsyncTask<NoteDOD, Void, Void> {
        private final NoteDODDao noteDODDao;

        private InsertNoteDodAsyncTask(NoteDODDao noteDODDao) { this.noteDODDao = noteDODDao; }

        @Override
        protected Void doInBackground(NoteDOD... noteDODS) {
            noteDODDao.insert(noteDODS[0]);
            return null;
        }
    }

    private static class UpdateNoteDodAsyncTask extends AsyncTask<NoteDOD, Void, Void> {
        private final NoteDODDao noteDODDao;

        private UpdateNoteDodAsyncTask(NoteDODDao noteDODDao) { this.noteDODDao = noteDODDao; }

        @Override
        protected Void doInBackground(NoteDOD... noteDODS) {
            noteDODDao.update(noteDODS[0]);
            return null;
        }
    }

    private static class DeleteNoteDodAsyncTask extends AsyncTask<NoteDOD, Void, Void> {
        private final NoteDODDao noteDODDao;

        private DeleteNoteDodAsyncTask(NoteDODDao noteDODDao) { this.noteDODDao = noteDODDao; }

        @Override
        protected Void doInBackground(NoteDOD... noteDODS) {
            noteDODDao.delete(noteDODS[0]);
            return null;
        }
    }

    private static class DeleteAllNoteDodAsyncTask extends AsyncTask<NoteDOD, Void, Void> {
        private final NoteDODDao noteDODDao;

        private DeleteAllNoteDodAsyncTask(NoteDODDao noteDODDao) { this.noteDODDao = noteDODDao; }

        @Override
        protected Void doInBackground(NoteDOD... noteDODS) {
            noteDODDao.deleteAllDodNotes();
            return null;
        }
    }
}
