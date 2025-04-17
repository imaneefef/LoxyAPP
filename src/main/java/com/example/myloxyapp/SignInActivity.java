package com.example.myloxyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button signInButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserCredentials", MODE_PRIVATE);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Retrieve saved credentials from SharedPreferences
                String savedUsername = sharedPreferences.getString("username", null);
                String savedPassword = sharedPreferences.getString("password", null);

                // Check if the entered username and password match the saved ones
                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    // Sign in successful
                    Toast.makeText(SignInActivity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();

                    // Redirect to DashboardActivity
                    startActivity(new Intent(SignInActivity.this, DashboardActivity.class));
                } else {
                    // Invalid credentials
                    Toast.makeText(SignInActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
