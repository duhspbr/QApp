package com.qualidade.qapp.data.remote.datasource;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.data.models.Psc;

@Database(entities = {Psc.class}, version = 1, exportSchema = true)
public abstract class DashboardDatabase extends RoomDatabase {

    private static DashboardDatabase instance;

    public abstract DashboardDao noteDaoPscDashBoard();

    public static synchronized DashboardDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DashboardDatabase.class, "psc_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
