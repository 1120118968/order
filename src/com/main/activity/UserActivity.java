package com.main.activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.main.db.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

	public class UserActivity extends Activity {

	    EditText edt_name;
	    EditText edt_sex;
	    EditText edt_age;

	    EditText edt_id;
	    EditText edt_health;
	    EditText edt_phone_number;
	    Button  add;
	    Button update;
	    Button select;
	    Button delete;
	    Button customer;
	    
	    private MySQLiteOpenHelper sqlHelper;
	    ListView listView;
	    String strname;
	    String strsex;
	    String strage;
	    String strid;
	    String strhealth;
	    String strphonenumber;
	    SQLiteDatabase db;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.acticity_user);
	        MySQLiteOpenHelper databaseHelper = new MySQLiteOpenHelper(this,"test",null,1);
	       db = databaseHelper.getWritableDatabase();
	       customer = (Button) findViewById(R.id.customer);
	       
	        //建立新表
	        edt_name = (EditText)findViewById(R.id.aname);
	        edt_sex =(EditText) findViewById(R.id.asex);
	        edt_age = (EditText)findViewById(R.id.aage);

	        edt_id = (EditText)findViewById(R.id.aid);
	        edt_health = (EditText)findViewById(R.id.ahealth);
	        edt_phone_number = (EditText)findViewById(R.id.aphonenumber);
	        add= (Button)findViewById(R.id.add);
	        update = (Button)findViewById(R.id.update);
	        delete =(Button)findViewById(R.id.delete);
	        select =(Button)findViewById(R.id.select);

	        //final SQLiteDatabase db = sqlHelper.getWritableDatabase();
	        listView = (ListView) findViewById(R.id.listview);
	        customer.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i = new Intent(UserActivity.this,CustomerActivity.class);
					startActivity(i);
				}
			});
	        add.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {

	                ContentValues values = new ContentValues();
	                /*
	                //插入第一组数据
	                values.put("id", "10001");
	                values.put("name", "Eastmount");
	                values.put("tel", "15201610000");
	                values.put("height", "172.5");
	                db.insert("Student", null, values);
	                */
	                values.put("username", edt_name.getText().toString());
	                values.put("sex", edt_sex.getText().toString());
	                values.put("age", edt_age.getText().toString());
	                values.put("health", edt_health.getText().toString());
	                values.put("phonenumber", edt_phone_number.getText().toString());
	                db.insert("user", null, values);
	                Toast.makeText(UserActivity.this, "数据插入成功", Toast.LENGTH_SHORT).show();
	                edt_name.setText("");
	                edt_sex.setText("");
	                edt_age.setText("");
	                edt_id.setText("");
	                edt_health.setText("");
	                edt_phone_number.setText("");

	            }
	        });
	        update.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	strid = edt_id.getText().toString();
	            	strage = edt_age.getText().toString();
	            	strname = edt_name.getText().toString();
	            	strsex = edt_sex.getText().toString();
	            	strhealth = edt_health.getText().toString();
	            	strphonenumber = edt_phone_number.getText().toString();
//	                ContentValues values = new ContentValues();
//	               values.put("username", edt_name.getText().toString());
	           //     values.put("sex", edt_sex.getText().toString());
	          //      values.put("age", edt_age.getText().toString());
	               // db.update("user", values, "username", new String[] {});
	                db.execSQL("update user set age = "+edt_age.getText().toString()+" where id = "+edt_id.getText().toString());
	                Toast.makeText(UserActivity.this, "更新数据", Toast.LENGTH_SHORT).show();
	            }
	        });
	        delete.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                db.execSQL("delete from user where id ="+ edt_id.getText().toString());
	                Toast.makeText(UserActivity.this, "删除数据", Toast.LENGTH_SHORT).show();
	            }
	        });
	        select.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                Cursor cursor = db.query("user", null, null, null, null, null, null);
	                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	                //适配器SimpleAdapter数据绑定
	                //错误:构造函数SimpleAdapter未定义 需把this修改为MainActivity.this
	                SimpleAdapter adapter = new SimpleAdapter(UserActivity.this, list, R.layout.list,
	                        new String[]{"id","username", "sex", "age","health","phonenumber"},
	                        new int[]{R.id.id,R.id.name, R.id.sex, R.id.age,R.id.health,R.id.phonenumber});
	                //读取数据 游标移动到下一行
	                while (cursor.moveToNext()) {
	                    Map<String, Object> Map = new HashMap<String, Object>();
	                    Map.put("id", cursor.getString(cursor.getColumnIndex("id")));
	                    Map.put("username", cursor.getString(cursor.getColumnIndex("username")));
	                    Map.put("sex", cursor.getString(cursor.getColumnIndex("sex")));
	                    Map.put("age", cursor.getString(cursor.getColumnIndex("age")));
	                    Map.put("health", cursor.getString(cursor.getColumnIndex("health")));
	                    Map.put("phonenumber", cursor.getString(cursor.getColumnIndex("phonenumber")));
	                    list.add(Map);
	                }
	                listView.setAdapter(adapter);
	            }

	        });



	}
	    }





