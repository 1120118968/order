package com.main.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CommentActivity extends Activity {

	Button publish;
	EditText edt_fankui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment);
		publish = (Button)findViewById(R.id.publish);
		edt_fankui = (EditText)findViewById(R.id.edt_fankui);
		publish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String fankui =edt_fankui.getText().toString();
				if(fankui.equals("") ){
					Toast.makeText(CommentActivity.this, "«Î ‰»Î∑¥¿°°£", Toast.LENGTH_SHORT).show();
				}else{
					
					
					// TODO Auto-generated method stub
					Intent i =new Intent(CommentActivity.this,CommentOverActivity.class);
					
					i.putExtra("fankui", edt_fankui.getText().toString());
	  
					
					startActivity(i);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comment, menu);
		return true;
	}

}
