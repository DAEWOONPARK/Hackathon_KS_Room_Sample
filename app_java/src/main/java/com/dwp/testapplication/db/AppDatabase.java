package com.dwp.testapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by dwp on 2020-11-05.
 */
@Database(entities = {TestData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract TestDao testDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , AppDatabase.class, "test_db")
                    .build();
        }
        return instance;
    }
}
