package com.example.ListViewTst;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by linyong on 14-8-16.
 */
public class MyServiceSample extends Activity implements View.OnClickListener{

    private Button startSrv;
    private Button stopSrv;
    private Button bindSrv;
    private Button unBindSrv;
    private MyService.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService.MyBinder)iBinder;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_main);


        startSrv = (Button)findViewById(R.id.startSrv);
        stopSrv = (Button)findViewById(R.id.stopSrv);
        bindSrv = (Button)findViewById(R.id.bindSrv);
        unBindSrv = (Button)findViewById(R.id.unbindSrv);

        startSrv.setOnClickListener(this);
        stopSrv.setOnClickListener(this);
        bindSrv.setOnClickListener(this);
        unBindSrv.setOnClickListener(this);

        Log.v("MyService", "MainThread id is "+Thread.currentThread().getId());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startSrv:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stopSrv:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bindSrv:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbindSrv:
                Intent unBindIntent = new Intent(this, MyService.class);
                unbindService(connection);
                break;
            default:
                break;
        }
    }

}