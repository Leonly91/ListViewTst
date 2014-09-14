package com.example.ListViewTst;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by linyong on 14-8-16.
 */
public class MyService extends Service {
    public static final String TAG = "MyServiceSample";
    private MyBinder binder = new MyBinder();

    public void onCreate() {
        Log.v("MyService", "Service id is " + Thread.currentThread().getId());
        super.onCreate();
        Log.v(TAG, "onCreate executed");

        Notification notification = new Notification(R.drawable.ic_launcher,
                "来着星星的通知", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        notification.setLatestEventInfo(this, "Title", "Content",pendingIntent);
        startForeground(1, notification);
    }

    public int onStartCommand(Intent intent, int flag, int startId) {
        Log.v(TAG, "onStartCommand executed");
        return super.onStartCommand(intent, flag, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    class MyBinder extends Binder {
        public void startDownload(){
            Log.d(TAG, "startDownload");
        }
    }
}
