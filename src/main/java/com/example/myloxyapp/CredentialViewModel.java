package com.example.myloxyapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CredentialViewModel extends AndroidViewModel {

    private CredentialRepository repository;

    public CredentialViewModel(Application application) {
        super(application);
        repository = new CredentialRepository(application);
    }

    public void insertCredential(Credential credential) {
        // Insert the credential in the background using ExecutorService from the repository
        repository.insert(credential);
    }

    public LiveData<List<Credential>> getAllCredentials() {
        return repository.getAllCredentials();
    }

    // Add the searchCredentials method to call the repository's search function
    public LiveData<List<Credential>> searchCredentials(String searchQuery) {
        return repository.searchCredentials(searchQuery);
    }
    public void deleteCredential(Credential credential) {
        repository.delete(credential);
    }

}
