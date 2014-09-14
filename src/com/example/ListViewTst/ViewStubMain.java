package com.example.ListViewTst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by linyong on 14-8-16.
 */
public class ViewStubMain extends Activity implements View.OnClickListener{
    static String SHOW_TEXT = "text";
    static String SHOW_IMG = "img";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstub_main);

        Button showTxt = (Button)findViewById(R.id.viewstub_showtext);
        Button showImg = (Button)findViewById(R.id.viewstub_showimage);
        showTxt.setOnClickListener(this);
        showImg.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent1 = new Intent(this, ViewStubActivity.class);
        switch (view.getId()){
            case R.id.viewstub_showtext:
                intent1.putExtra("show", SHOW_TEXT);
                break;
            case R.id.viewstub_showimage:
                intent1.putExtra("show", SHOW_IMG);
                break;
        }

        startActivity(intent1);
    }
}