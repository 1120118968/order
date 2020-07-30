package com.main.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;


public class ListView extends Activity {
	private android.widget.ListView listView1 = null;
	private String[] place={"北京","天津","上海","重庆","沈阳"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView1=(android.widget.ListView)findViewById(R.id.l1);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,place);
        (listView1).setAdapter(adapter);
        listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String bookname=place[arg2];
				Intent intent=new Intent();
				intent.putExtra("place", bookname);
				//intent.putExtra("phone", phone);
				setResult(1,intent);
				finish();
			}
		});
    }

        
    }

    



