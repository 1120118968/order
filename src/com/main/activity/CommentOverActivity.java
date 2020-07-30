package com.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CommentOverActivity extends Activity {

	TextView show;

	Button look;
	String fankui ="";	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment_over);
		show = (TextView)findViewById(R.id.show);
		look = (Button)findViewById(R.id.look);
	
	
		look.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i =getIntent();
				fankui=i.getStringExtra("fankui");
				show.setText(fankui);
			}
		});

	}
}
