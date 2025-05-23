package com.example.myloxyapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Credential.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CredentialDao credentialDao();
}
