package com.example.myloxyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button addCredentialsButton, viewSavedCredentialsButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        addCredentialsButton = findViewById(R.id.addCredentialsButton);
        viewSavedCredentialsButton = findViewById(R.id.viewSavedCredentialsButton);
        logoutButton = findViewById(R.id.logoutButton);

        addCredentialsButton.setOnClickListener(v -> {
            // Redirect to AddCredentialsActivity
            Intent intent = new Intent(DashboardActivity.this, AddCredentialsActivity.class);
            startActivity(intent);
        });

        viewSavedCredentialsButton.setOnClickListener(v -> {
            // Redirect to ViewSavedCredentialsActivity
            Intent intent = new Intent(DashboardActivity.this, ViewSavedCredentialsActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            // Redirect to MainActivity
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            // Clear the activity stack to prevent returning to DashboardActivity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish(); // Close the DashboardActivity
        });
    }
}
