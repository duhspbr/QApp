package com.qualidade.qapp.data.remote.datasource;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.data.models.Psc;

@Database(entities = {Psc.class}, version = 1, exportSchema = false)
public abstract class PscDatabase extends RoomDatabase {

    private static PscDatabase instance;

    public abstract PscDao notePSCDao();

    public static synchronized PscDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PscDatabase.class, "psc_database")
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
        private final PscDao pscDao;

        private PopulateDbAsyncTask(PscDatabase db) { pscDao = db.notePSCDao(); }

        @Override
        protected Void doInBackground(Void... voids) {
            pscDao.insert(new Psc("Fernanda", "diurno a", "manuseio", "santander", "conta mais", "FF34F", "212", "233", "12", "OK", "22/11/2002", "15:00"));
            pscDao.insert(new Psc("Freeman", "diurno b", "manuseio", "itaú", "conta select", "FF34F", "450", "21", "1", "NOK", "15/10/2020", "12:00"));
            pscDao.insert(new Psc("Nalva", "noturno a", "manuseio", "safra", "elite", "FF34F", "212", "122", "1", "OK", "15/10/2020", "12:00"));
            pscDao.insert(new Psc("Dava", "noturno f", "manuseio", "safra", "elite", "FF34F", "22", "122", "1", "NOK", "15/10/2020", "12:00"));
            return null;
            }
    }
}
