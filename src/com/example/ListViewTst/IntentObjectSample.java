package com.example.ListViewTst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by linyong on 14-8-16.
 */
public class IntentObjectSample extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_main);
        Button serialBtn = (Button) findViewById(R.id.serialBtn);
        Button pacelBtn = (Button) findViewById(R.id.pacelBtn);
        serialBtn.setOnClickListener(this);
        pacelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.serialBtn:
                break;
            case R.id.pacelBtn:
                break;
            default:
                break;
        }
    }



}