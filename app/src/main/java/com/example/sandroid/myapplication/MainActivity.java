package com.example.sandroid.myapplication;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    Button btnNotification;
    Intent intent;
    PendingIntent pendingIntent;
    NotificationManager notificationManager;
    NotificationCompat.Builder notification;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        init();
        context = MainActivity.this;
        btnNotification = (Button) findViewById(R.id.tv_1);
        intent = new Intent(context, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        btnNotification.setOnClickListener(this);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notification = new NotificationCompat.Builder(this).setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Title").setContentText("description").setContentIntent(pendingIntent);

    }

    private void init() {

    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                sendNotification();
                break;
        }

    }

    private void sendNotification() {
        notificationManager.notify(0, notification.build());
    }

}
