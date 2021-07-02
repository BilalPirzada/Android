package com.practise.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STEPS
        // 1. CREATE NOTIFICATION BUILDER
        // 2. CREATE A NOTIFICATION MANAGER
        // 3. CREATE NOTIFICATION CHANNEL
        // 4. SHOW THE NOTIFICATION USING MANAGER

        //PENDING INTENT
        // FOR OPENING ACTIVITY WHEN WE CLICK ON NOTIFICATION
        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity
                (this, 0 , intent, 0);


        // 1. CREATING NOTIFICATION WITH NOTIFICATION BUILDER
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyNotification")
                .setContentTitle("This is my title")
                .setSmallIcon(R.drawable.ic_launcher_background) // notification icon
                .setAutoCancel(true) // to disappear notification when clicked
                .setContentText("This is my text")
                .setContentIntent(pendingIntent); //open mainActivity on click on notification


        //2. CREATE A NOTIFICATION MANAGER
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //3. CREATING NOTIFICATION CHANNEL
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)  //IF VERSION IS GREATER THAN OREO
        {
            //CREATING CHANNEL
            NotificationChannel channel=
                    new NotificationChannel
                            ("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(channel);

            builder.setChannelId("MyNotification");
        }

        //4. SHOW THE NOTIFICATION USING MANAGER
        manager.notify(999, builder.build());

    }
}
