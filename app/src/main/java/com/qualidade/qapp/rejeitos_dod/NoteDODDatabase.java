package com.qualidade.qapp.rejeitos_dod;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.dashboard.NoteDashBoardDao;

@Database(entities = { NoteDOD.class }, version = 1)
public abstract class NoteDODDatabase extends RoomDatabase {

    private static NoteDODDatabase instance;

    public abstract NoteDODDao noteDaoDOD();

    public static synchronized NoteDODDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDODDatabase.class, "note_dod_database")
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
        private final NoteDODDao noteDODDao;

        private PopulateDbAsyncTask(NoteDODDatabase db) { noteDODDao = db.noteDaoDOD(); }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDODDao.insert(new NoteDOD("Santander", "DOD#2", "NOTURNO", "GAV 1", "15 - PERSO", "12", "22-02-2020", "15:25"));
            noteDODDao.insert(new NoteDOD("Itaú", "DOD#3", "DIURNO", "PACK 2", "12", "130", "21-02-2020", "04:20"));
            noteDODDao.insert(new NoteDOD("Itaú", "DOD#3", "NOTURNO", "PACK 1", "15", "102", "18-02-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("NUBANK", "DOD#3", "NOTURNO", "PACK 1", "15", "102", "19-02-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("C6", "DOD#3", "DIURNO", "PACK 1", "15", "102", "03-02-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("Bradesco", "DOD#3", "NOTURNO", "GAV 1", "15", "102", "14-02-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("CAJU", "DOD#3", "NOTURNO", "PACK 1", "15", "102", "28-09-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("NEON", "DOD#3", "NOTURNO", "GAV 1", "15", "102", "02-08-2020", "08:00"));
            noteDODDao.insert(new NoteDOD("BB", "DOD#3", "DIURNO", "PACK 1", "15", "102", "03-01-2020", "08:00"));

            return null;
        }
    }
}
