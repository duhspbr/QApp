package com.qualidade.qapp.psc_bancario;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {NotePSC.class}, version = 1)
public abstract class NotePSCDatabase extends RoomDatabase {

    private static NotePSCDatabase instance;

    public abstract NotePSCDao notePSCDao();

    public static synchronized NotePSCDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NotePSCDatabase.class, "note_psc_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private final NotePSCDao notePSCDao;

        private PopulateDbAsyncTask(NotePSCDatabase db) { notePSCDao = db.notePSCDao(); }

        @Override
        protected Void doInBackground(Void... voids) {
            notePSCDao.insert(new NotePSC("diurno a", "manuseio", "santander", "conta mais", "FF34F", "212", "233", "12", "OK", "22/11/2002", "15:00"));
            notePSCDao.insert(new NotePSC("diurno b", "manuseio", "itaú", "conta select", "FF34F", "450", "21", "1", "NOK", "15/10/2020", "12:00"));
            notePSCDao.insert(new NotePSC("noturno a", "manuseio", "safra", "elite", "FF34F", "212", "122", "1", "OK", "15/10/2020", "12:00"));
            notePSCDao.insert(new NotePSC("noturno f", "manuseio", "safra", "elite", "FF34F", "22", "122", "1", "NOK", "15/10/2020", "12:00"));
            return null;
            }
    }
}
