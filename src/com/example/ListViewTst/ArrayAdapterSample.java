package com.example.ListViewTst;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by linyong on 14-8-10.
 */
public class ArrayAdapterSample extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_adaper);

        String[] str = {"Hello", "world", "hahaha"};
        ListView listView = (ListView)findViewById(R.id.arrayListView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, str));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}