package com.example.myloxyapp;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CredentialRepository {

    private CredentialDao credentialDao;
    private LiveData<List<Credential>> allCredentials;
    private Executor executor;

    public CredentialRepository(Application application) {
        AppDatabase db = DatabaseHelper.getDatabase(application);
        credentialDao = db.credentialDao();
        allCredentials = credentialDao.getAllCredentials();
        executor = Executors.newSingleThreadExecutor();  // Creating an Executor for background tasks
    }

    public void insert(Credential credential) {
        executor.execute(() -> credentialDao.insert(credential));  // Run insert operation on background thread
    }

    public LiveData<List<Credential>> getAllCredentials() {
        return allCredentials;  // Return LiveData to be observed in ViewModel
    }

    // Add the method to search credentials in the repository
    public LiveData<List<Credential>> searchCredentials(String searchQuery) {
        return credentialDao.searchCredentials(searchQuery); // Return LiveData from Dao
    }
    public void delete(Credential credential) {
        executor.execute(() -> credentialDao.delete(credential));
    }

}
