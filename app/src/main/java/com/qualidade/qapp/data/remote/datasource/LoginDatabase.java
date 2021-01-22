package com.qualidade.qapp.data.remote.datasource;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.data.models.Login;

@Database(entities = { Login.class }, version = 1, exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {

    private static LoginDatabase instance;

    public abstract LoginDao loginDao();

    public static synchronized LoginDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LoginDatabase.class, "login_database")
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
        private final LoginDao loginDao;

        private PopulateDbAsyncTask(LoginDatabase db) { loginDao = db.loginDao(); }

        @Override
        protected Void doInBackground(Void... voids) {
            loginDao.insert(new Login("Edu", "123"));
            return null;
        }
    }
}
