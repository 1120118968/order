package com.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.main.style.ChCai;
import com.main.style.GuoZai;
import com.main.style.JiuShui;
import com.main.style.LuCai;
import com.main.style.Tangtang;
import com.main.style.YueCai;

public class InitMenuView extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter);
      //  Button jiezhang = (Button) findViewById(R.id.jiezhang);
        Button back=(Button) findViewById(R.id.back);
        ImageButton yuecai=(ImageButton) findViewById(R.id.ayue);
        ImageButton lucai=(ImageButton)findViewById(R.id.alu);
        ImageButton chuancai=(ImageButton)findViewById(R.id.achuan);
        ImageButton guozai=(ImageButton)findViewById(R.id.aguo);
        ImageButton tang=(ImageButton)findViewById(R.id.atang);
        ImageButton jiushui=(ImageButton)findViewById(R.id.ajiushui);
        Button returnfirst=(Button)findViewById(R.id.returnfirst);
        Button dafen=(Button)findViewById(R.id.dafen);
        Button finish = (Button)findViewById(R.id.finish);
        finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent (InitMenuView.this,DesktopActivity.class);
				startActivity(i);
			}
		});
        
        dafen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i =new Intent(InitMenuView.this,CommentActivity.class);
				startActivity(i);
			}
		});
//        jiezhang.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent i =new Intent(InitMenuView.this,CalculateActivity.class);
//				startActivity(i);
//			}
//		});
        returnfirst.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,WelcomeActivity.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
guozai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,GuoZai.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
tang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,Tangtang.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
jiushui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,JiuShui.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
       
   chuancai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,ChCai.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
        lucai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,LuCai.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
yuecai.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,YueCai.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		Intent intent=new Intent(InitMenuView.this,Recevier.class);		// TODO Auto-generated method stub
				startActivity(intent);
			}
		});
    }
}