/*package com.example.myloxyapp.sensor;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.example.myloxyapp.R;
import com.example.myloxyapp.ViewSavedCredentialsActivity;

public class ShakeService extends Service implements SensorEventListener {

    private static final float SHAKE_THRESHOLD_GRAVITY = 2.3F; // Sensitivity threshold
    private static final int SHAKE_SLOP_TIME_MS = 500; // Minimum time interval between shakes
    private long lastShakeTime = 0;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize sensor manager and accelerometer
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        // Register listener
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }

        // Set up stop-service intent
        Intent stopIntent = new Intent(this, ShakeService.class);
        stopIntent.setAction("STOP_SERVICE");
        PendingIntent stopServicePendingIntent = PendingIntent.getService(
                this,
                0,
                stopIntent,
                PendingIntent.FLAG_IMMUTABLE
        );

        // Create and display the notification
        Notification notification = new NotificationCompat.Builder(this, NotificationHelper.CHANNEL_ID)
                .setContentTitle("SafeLog")
                .setContentText("Shake your device to open the search bar (click to stop the service).")
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(stopServicePendingIntent)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .build();

        startForeground(1, notification); // Start service in the foreground
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister the sensor listener to clean up resources
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && "STOP_SERVICE".equals(intent.getAction())) {
            stopSelf(); // Stop the service
            return START_NOT_STICKY;
        }
        return START_STICKY;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float gForce = (float) Math.sqrt((x * x) + (y * y) + (z * z)) / SensorManager.GRAVITY_EARTH;

            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                long currentTime = System.currentTimeMillis();
                if (lastShakeTime + SHAKE_SLOP_TIME_MS > currentTime) {
                    return;
                }

                lastShakeTime = currentTime;

                // Open the search bar
                Intent searchIntent = new Intent(this, ViewSavedCredentialsActivity.class);
                searchIntent.putExtra("select_search_bar", true);
                searchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(searchIntent);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not implemented
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // This service is not bound
    }
}*/
