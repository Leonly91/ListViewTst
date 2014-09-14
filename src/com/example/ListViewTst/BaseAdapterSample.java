package com.example.ListViewTst;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseAdapterSample extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_adapter);

        ListView listView = (ListView)findViewById(R.id.baseList);
        listView.setAdapter(new MyBaseAdpater(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("MyListViewBase", "你点击了第 " + i + "行");
            }
        });
    }

    private ArrayList<HashMap<String, Object>> getData(){
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i< 20; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", "第"+i+"行");
            map.put("ItemText", "这是第"+"行");
            list.add(map);
        }
        return list;
    }

    private class MyBaseAdpater extends BaseAdapter {
        private LayoutInflater mInFlater;
        public MyBaseAdpater(Context context){
            this.mInFlater = LayoutInflater.from(context);
        }

        public int getCount(){
            Log.v("MyListViewBase", "getCount()" + getData().size());
            return getData().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            Log.v("MyListViewBase", "getView " + i + " " + view);
            if (view == null){
                view = mInFlater.inflate(R.layout.base_item, null);
                holder = new ViewHolder();
                holder.title = (TextView)view.findViewById(R.id.ItemTitle);
                holder.text = (TextView)view.findViewById(R.id.ItemText);
                holder.btn = (Button)view.findViewById(R.id.baseBtn);
                view.setTag(holder);
            }
            else{
                holder = (ViewHolder)view.getTag();
            }
            holder.title.setText(getData().get(i).get("ItemTitle").toString());
            holder.text.setText(getData().get(i).get("ItemText").toString());
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("MyListViewBase", "你点击了按钮"+i);
                }
            });
            return view;
        }


    }

    public final class ViewHolder{
        public TextView title;
        public TextView text;
        public Button btn;
    }
}