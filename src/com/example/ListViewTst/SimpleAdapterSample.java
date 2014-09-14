package com.example.ListViewTst;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by linyong on 14-8-10.
 */
public class SimpleAdapterSample extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adapter);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i<20; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("title", "title:"+i);
            map.put("text", "text:"+i);
            arrayList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.simple_item, new String[]{"title", "text"}, new int[]{R.id.sample_title, R.id.sample_text}){
            public View getView(final int position, View view, ViewGroup group){
                if (view == null){
                    view = View.inflate(SimpleAdapterSample.this, R.layout.simple_item, null);
                }
                final Button button = (Button)view.findViewById(R.id.simpleBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SimpleAdapterSample.this, "You click btn : "+position, Toast.LENGTH_SHORT).show();
                    }
                });

                return super.getView(position, view, group);
            }
        };

        ListView listView = (ListView)findViewById(R.id.simpleListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SimpleAdapterSample.this, "You click item "+i, Toast.LENGTH_SHORT).show();
            }
        });

    }
}