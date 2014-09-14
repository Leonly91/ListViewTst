package com.example.ListViewTst;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by linyong on 14-8-11.
 */
public class SyncTstActivity extends Activity {
    private static Handler handler;
    private int count = 0;
    private TextView textView;
    private Button startBtn;
    private Button stopBtn;
    private boolean runFlag = false;
    private static Thread startThread;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sync_main);

        textView = (TextView)findViewById(R.id.sync_text);
        textView.setText(count + "");
        startBtn = (Button)findViewById(R.id.sync_startBtn);
        stopBtn = (Button)findViewById(R.id.sync_stopBtn);

        if (handler == null) {
            handler = new Handler();
        }
        if (startThread == null){
            startThread = new Thread(new StartCntThread());
        }


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(startThread);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(startThread);
                Log.v("MyListViewBase", "remove cnt thread");

            }
        });
    }

    private class StartCntThread implements Runnable{

        @Override
        public void run() {
            Log.v("MyListViewBase", "run() :" + Thread.currentThread().getId());
            count++;
            textView.setText(count + "");
            handler.postDelayed(startThread, 1000);


        }
    }
}