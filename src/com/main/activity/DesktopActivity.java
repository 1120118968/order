package com.main.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DesktopActivity extends Activity {
	private Spinner desktopid=null;
//	private Spinner orderid=null;
	private String[] desktop = new String[]{"1","2","3","4",
			"5"
	};
	private String[] order = new String[]{"001","002","003","004",
			"005"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_desktop);
		
//		orderid = (Spinner)findViewById(R.id.orderid);
//		 ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,order);
//	        orderid.setAdapter(adapter1);
//	        orderid.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//	        	
//
//				@Override
//				public void onNothingSelected(AdapterView<?> arg0) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void onItemSelected(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					// TODO Auto-generated method stub
//					Toast.makeText(DesktopActivity.this, "您选择了"+(arg2+1)+"号订单", Toast.LENGTH_SHORT).show();
//				  arg2=0;
//				}
//			});

		desktopid=(Spinner)findViewById(R.id.desktopid);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,desktop);
        desktopid.setAdapter(adapter);
        desktopid.setOnItemSelectedListener(new OnItemSelectedListener() {

	

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(DesktopActivity.this, "您选择了"+(arg2+1)+"号桌", Toast.LENGTH_SHORT).show();
			
				  arg2=0;
			}
		});
        Button enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i =new  Intent(DesktopActivity.this,InitMenuView.class);
				startActivity(i);
			}
		});
    

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.desktop, menu);
		return true;
	}

}
