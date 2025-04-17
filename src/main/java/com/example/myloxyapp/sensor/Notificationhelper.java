/*package com.example.myloxyapp.sensor;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

// This class provides the tools to create a notification, which will inform the user of the ongoing background service for the app
public class NotificationHelper {
    public static final String CHANNEL_ID = "SafeLogChannel";

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "SafeLog",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            serviceChannel.setDescription("SafeLog notification");

            NotificationManager manager = context.getSystemService(NotificationManager.class); // Get the notification Manager for this device
            manager.createNotificationChannel(serviceChannel); // Sends the created notification on the channel through the Notification Manager
        }
    }
}*/