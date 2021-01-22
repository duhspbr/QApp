package com.qualidade.qapp.data.remote.datasource;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.data.models.Dod;

@Database(entities = { Dod.class }, version = 1, exportSchema = false)
public abstract class DodDatabase extends RoomDatabase {

    private static DodDatabase instance;

    public abstract DodDao noteDaoDOD();

    public static synchronized DodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DodDatabase.class, "dod_database")
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
        private final DodDao dodDao;

        private PopulateDbAsyncTask(DodDatabase db) { dodDao = db.noteDaoDOD(); }

        @Override
        protected Void doInBackground(Void... voids) {
            dodDao.insert(new Dod("Freeman", "Santander", "DOD#2", "NOTURNO", "GAV 1", "15 - PERSO", 120, "22-02-2020", "15:25"));
            return null;
        }
    }
}
