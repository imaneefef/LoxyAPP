package com.example.myloxyapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "credentials")
public class Credential {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String appName;
    public String alias;
    public String login;
    public String password; // You may want to store this securely (hashed or encrypted)

    // Constructor, getters, and setters
    public Credential(String appName, String alias, String login, String password) {
        this.appName = appName;
        this.alias = alias;
        this.login = login;
        this.password = password;
    }
}
