package com.main.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PersonActivity extends Activity {

	private ListView listView1;
	private String[] books = new String[]{"xx    男","android开发案例驱动教程","Android揭秘","疯狂Android讲义",
			"Android从零开始"
	};
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_person);
	        listView1=(ListView)findViewById(R.id.listView1);
	        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,books);
	        listView1.setAdapter(adapter);
	        listView1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					String bookname=books[arg2];
					  Toast.makeText(PersonActivity.this, "您删除了"+bookname, Toast.LENGTH_SHORT).show();
					  listView1.removeViews(arg2, arg2);
					
					  
					  
				}

			
			});  
	        listView1.setAdapter(adapter);
	    }


}
