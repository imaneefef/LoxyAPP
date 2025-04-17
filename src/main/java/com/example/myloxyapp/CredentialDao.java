package com.example.myloxyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CredentialDao {

    @Insert
    void insert(Credential credential);

    @Delete
    void delete(Credential credential);

    @Query("SELECT * FROM credentials WHERE appName LIKE :searchQuery")
    LiveData<List<Credential>> searchCredentials(String searchQuery);

    @Query("SELECT * FROM credentials")
    LiveData<List<Credential>> getAllCredentials();
}
