package com.example.ListViewTst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;

/**
 * Created by linyong on 14-8-16.
 */
public class ViewStubActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstub);

        Intent intent = getIntent();
        if (intent != null){
            String str = intent.getStringExtra("show");
            if (str.equals(ViewStubMain.SHOW_TEXT)){
                ViewStub txtStub1 = (ViewStub)findViewById(R.id.viewstub_text);
                txtStub1.inflate();
            }else{
                ViewStub txtStub2 = (ViewStub)findViewById(R.id.viewstub_image);
                txtStub2.inflate();
            }
        }
    }
}