package com.example.ListViewTst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.logging.LogRecord;

public class MyActivity extends Activity {
    private static Sample[] samples;
    private Handler hanlder;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        samples = new Sample[]{
                new Sample(R.string.ArrayAdapterSample, ArrayAdapterSample.class),
                new Sample(R.string.SimpleAdapterSample, SimpleAdapterSample.class),
                new Sample(R.string.BaseAdapterSample, BaseAdapterSample.class),
                new Sample(R.string.sync_counter, SyncTstActivity.class),
                new Sample(R.string.ServiceSample, MyServiceSample.class),
                new Sample(R.string.InentSample, IntentObjectSample.class),
                new Sample(R.string.viewstub, ViewStubMain.class),
                new Sample(R.string.actionbar_tst, ActionBarActivity.class),
        };

        ListView listView = (ListView)findViewById(R.id.sampleList);
        listView.setAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                samples));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MyActivity.this, samples[i].activityClass));
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                hanlder = new Handler();

                Message msg = new Message();
                msg.arg1 = 1;
                Bundle bundle = new Bundle();
                bundle.putString("msg", "hello");
                msg.setData(bundle);

                hanlder.sendMessage(msg);
            }
        }).start();
    }

    private class Sample{
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass){
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        public String toString(){return title.toString();}
    }

}
