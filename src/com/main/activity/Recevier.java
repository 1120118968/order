package com.main.activity;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.main.db.DBHelper;

public class Recevier extends Activity {
    
	/** Called when the activity is first created. */
	 Cursor c;
  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
      //  li=(ListView)findViewById(R.id.list1);
        
    
       final DBHelper helpter = new DBHelper(this);//创建数据库辅助类
               c = helpter.query();  //查询数据库信息
               String[] from = { "_id", "name", "url","desc" };  //需要查询的信息
              int[] to = { R.id.a, R.id.b, R.id.c, R.id.d};  
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,  
                     R.layout.list2, c, from, to);  //配置适配器
               ListView listView = (ListView) findViewById(R.id.list1);  //显示信息的列表
               listView.setAdapter(adapter); //绑定适配器
               ImageButton delete=(ImageButton)findViewById(R.id.x0delete);
               delete.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					c.close();// TODO Auto-generated method stub
					helpter.clean();
					
				}
			});
            ImageButton resset=(ImageButton)findViewById(R.id.x0reset);
            resset.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(Recevier.this,InitMenuView.class);		// TODO Auto-generated method stub
					startActivity(intent);
					// TODO Auto-generated method stub
					
					
				}
			});
             final AlertDialog.Builder builder = new AlertDialog.Builder(this);  
                     listView.setOnItemClickListener(new OnItemClickListener() {  
                        @Override  
                         public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,  
                                 long arg3) {  
                             final long temp = arg3;  
                            builder.setMessage("确定删除信息？").setPositiveButton("确定",  
                                    new DialogInterface.OnClickListener() {  
                                        public void onClick(DialogInterface dialog,  
                                                int which) {  
                                           helpter.del((int)temp);  
                                           c = helpter.query();  
                                          String[] from = { "_id", "name", "url", "desc" };  
                                           int[] to = { R.id.text20, R.id.text20, R.id.text20, R.id.text20 };  
                                           SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),  
                                                   R.layout.list, c, from, to);  
                                           ListView listView = (ListView) findViewById(R.id.list1);   
                                           listView.setAdapter(adapter);  
                                        }  
                                   }).setNegativeButton("取消",  
                                    new DialogInterface.OnClickListener() {  
                                       public void onClick(DialogInterface dialog,  
                                               int which) {  
                                             
                                      }  
                                    });  
                            AlertDialog ad = builder.create();  
                           ad.show();  
                        }  
                    });  

             
               helpter.close();  
               
              }
    }
