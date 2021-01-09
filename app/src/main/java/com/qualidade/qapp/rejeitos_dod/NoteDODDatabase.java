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
            noteDODDao.insert(new NoteDOD("Freeman", "Santander", "DOD#2", "NOTURNO", "GAV 1", "15 - PERSO", 120, "22-02-2020", "15:25"));
            return null;
        }
    }
}
