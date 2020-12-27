package com.qualidade.qapp.dashboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.qualidade.qapp.psc_bancario.NotePSC;
import com.qualidade.qapp.rejeitos_dod.NoteDOD;

@Database(entities = {NotePSC.class}, version = 1)
public abstract class NoteDashBoardPscDatabase extends RoomDatabase {

    private static NoteDashBoardPscDatabase instance;

    public abstract NoteDashBoardDao noteDaoPscDashBoard();

    public static synchronized NoteDashBoardPscDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDashBoardPscDatabase.class, "note_psc_database")
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


//@Database(entities = {NoteDOD.class}, version = 1)
//public abstract class NoteDashBoardDodDatabase extends RoomDatabase {
//
//    private static NoteDashBoardDodDatabase instance;
//
//    public abstract NoteDODDao noteDaoDOD();
//
//    public static synchronized NoteDashBoardDodDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(),
//                    NoteDashBoardDodDatabase.class, "note_dod_database")
//                    .fallbackToDestructiveMigration()
//                    .addCallback(roomCallback)
//                    .build();
//        }
//        return instance;
//    }
//
//    private static final Callback roomCallback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//        }
//    };
//}
