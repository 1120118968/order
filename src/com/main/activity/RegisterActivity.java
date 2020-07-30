package com.main.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RegisterActivity extends Activity {
private EditText et1=null;
private EditText et2=null;
private EditText et3=null;
private EditText et4=null;
private RadioGroup gender=null;
private String str=null;
private RadioButton rd1=null;
private RadioButton rd2=null;
private Button bt1=null;
private Button bt2=null;
private String nameText=null;
private String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        gender=(RadioGroup)findViewById(R.id.radioGroup1);
        rd1=(RadioButton)findViewById(R.id.rd1);
        rd2=(RadioButton)findViewById(R.id.rd2);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(RegisterActivity.this,ListView.class);
				startActivityForResult(intent, 1);
			}
			
			

		});
       
        gender.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(rd1.getId()==arg1)
					str=rd1.getText().toString();
				else
					str=rd2.getText().toString();
			}
		});
    }
        public void register(View view){
      	  String username=et1.getText().toString().trim();
      	  String password=et2.getText().toString().trim();
      	  String passwordt=et3.getText().toString().trim();
      	  String places=et4.getText().toString().trim();
      	  String check=Check();
      	  if(check!=null){
      		  Builder builder=new AlertDialog.Builder(RegisterActivity.this);
      		  builder.setTitle("出错提示");
      		  builder.setMessage(check);
      		  builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					et2.setText("");
					et3.setText("");
					
				}
			});
      		  builder.show();
      	  }else{
      		Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
				intent.putExtra("username", et1.getText().toString());
				intent.putExtra("password", et2.getText().toString());
				intent.putExtra("gender", str);
				intent.putExtra("places", places);
				startActivity(intent);
//				Toast t = new Toast(RegisterActivity.this);
//				t.setDuration(Toast.LENGTH_SHORT);
//				t.setText("");
//				t.show();
				Toast.makeText(RegisterActivity.this, "注册成功，即将跳转登录", Toast.LENGTH_SHORT).show();
      	  }}
      	  /*if(TextUtils.isEmpty(username)){
      		  Toast.makeText(this, "用户名不能为空", 0).show();}
      		  if(password.length()<6||password.length()>15){
      			Toast.makeText(this, "密码应该在6~15位之间", 0).show();
      		  }
      	  if(TextUtils.isEmpty(username)){
      		Toast.makeText(this, "用户名不能为空", 0).show();
      	  }else{
      		
      	  else if(password.length()<6||password.length()>15){
      		Toast.makeText(this, "密码应该在6~15位之间", 0).show();
     		  }else if(password.equals(passwordt)){
     			 Intent intent =new Intent(RegisterActivity.this,SecondActivity.class);
  				intent.putExtra("username", et1.getText().toString());
  				intent.putExtra("password", et2.getText().toString());
  				intent.putExtra("gender", str);
  				intent.putExtra("places", places);
  				startActivity(intent);
     			 
     		  }else{
     			 Toast.makeText(this, "两次输入密码不一致", 0).show();
     		  }*/
      	
    
        public String Check(){
        	if(TextUtils.isEmpty(et1.getText().toString().trim())){
          		return "用户名不能为空";
          	  }/*else{*/
          		
          	   if(et2.getText().toString().trim().length()<6||et2.getText().toString().trim().length()>15){
          		return  "密码应该在6~15位之间";
         		  }
          	   if(!et2.getText().toString().trim().equals(et3.getText().toString().trim())){
          		 return "两次输入密码不一致";
         		  }
          	   return null;
        }
        
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			
			if(data !=null){
				if(requestCode==1){
					if(resultCode==1){
						try{
							name=data.getStringExtra("place");
							//phone=data.getStringExtra("phone");
						}catch(Exception e){
							
						}
						if(name!=null)
							et4.setText(name);
						
					}}}}
   
   }


