package com.example.myloxyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddCredentialsActivity extends AppCompatActivity {

    private EditText appNameEditText, aliasEditText, loginEditText, passwordEditText;
    private Button saveButton;
    private CredentialViewModel credentialViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credentials);

        appNameEditText = findViewById(R.id.appNameEditText);
        aliasEditText = findViewById(R.id.aliasEditText);
        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        saveButton = findViewById(R.id.saveButton);

        // Initialize ViewModel
        credentialViewModel = new ViewModelProvider(this).get(CredentialViewModel.class);

        saveButton.setOnClickListener(v -> {
            String appName = appNameEditText.getText().toString();
            String alias = aliasEditText.getText().toString();
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Create a new Credential object
            Credential credential = new Credential(appName, alias, login, password);

            // Insert the credential into the database
            credentialViewModel.insertCredential(credential);

            // Show toast
            Toast.makeText(AddCredentialsActivity.this, "Credentials saved!", Toast.LENGTH_SHORT).show();

            // Close activity and go back to dashboard
            finish();
        });
    }
}
