package com.example.myloxyapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ViewSavedCredentialsActivity extends AppCompatActivity {

    private ListView credentialsListView;
    private SearchView searchView;
    private CredentialsAdapter credentialsAdapter;
    private CredentialViewModel credentialViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved_credentials);

        credentialsListView = findViewById(R.id.credentialsListView);
        searchView = findViewById(R.id.searchView);

        // Initialize ViewModel
        credentialViewModel = new ViewModelProvider(this).get(CredentialViewModel.class);

        // Initialize adapter and set it to ListView
        credentialsAdapter = new CredentialsAdapter(this);
        credentialsListView.setAdapter(credentialsAdapter);

        // Set the delete functionality
        credentialsAdapter.setOnDeleteClickListener(new CredentialsAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(Credential credential) {
                // Call ViewModel to delete the credential
                credentialViewModel.deleteCredential(credential);
            }
        });

        // Observe LiveData to fetch and display the credentials
        credentialViewModel.getAllCredentials().observe(this, new Observer<List<Credential>>() {
            @Override
            public void onChanged(List<Credential> credentials) {
                if (credentials != null) {
                    credentialsAdapter.setCredentials(credentials);
                }
            }
        });

        // Implement search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search when submit
                searchCredentials(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search when the text changes
                searchCredentials(newText);
                return true;
            }
        });
    }

    private void searchCredentials(String searchQuery) {
        // Observe search results from the ViewModel
        credentialViewModel.searchCredentials(searchQuery).observe(this, new Observer<List<Credential>>() {
            @Override
            public void onChanged(List<Credential> credentials) {
                if (credentials != null) {
                    credentialsAdapter.setCredentials(credentials); // Update the adapter with the search results
                }
            }
        });
    }
}
