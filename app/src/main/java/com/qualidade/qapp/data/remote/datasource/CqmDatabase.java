package com.qualidade.qapp.data.remote.datasource;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.data.models.Cqm;

import java.net.ContentHandler;

@Database(entities = { Cqm.class }, version = 1, exportSchema = true)
public abstract class CqmDatabase extends RoomDatabase {

    private static CqmDatabase instance;
    public abstract CqmDao cqmDao();

    public static synchronized CqmDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CqmDatabase.class, "cqm_database")
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
        private final CqmDao cqmDao;

        private PopulateDbAsyncTask(CqmDatabase db) { cqmDao = db.cqmDao(); }

        @Override
        protected Void doInBackground(Void... voids) {
            cqmDao.insert(new Cqm("MX23", "23/02/2021", "12:21", "ROT",
                    "ROT", "ROT", "ROT", "ROT", "ROT", "ROT",
                    "ROT", "ROT", "ROT", "ROT", "ROT", "NA",
                    "NA", "NA", "NA", "NA", "NA", "NA",
                    "NA", "NA", "NA", "NA", "NA", "NA",
                    "NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA",
                    "NA", "NA", "NA"));
            return null;
        }
    }

}
