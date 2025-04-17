package com.example.myloxyapp;

import androidx.room.Room;
import android.content.Context;

public class DatabaseHelper {

    private static AppDatabase appDatabase;

    // Thread-safe Singleton pattern for AppDatabase
    public static synchronized AppDatabase getDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "credentials-db")
                    .fallbackToDestructiveMigration() // Handle migrations appropriately
                    .build();
        }
        return appDatabase;
    }
}
