package com.main.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public Context mContext;

    //用户表 id username sex age
    public static final String createTableStu = "create table user (" +
            "id integer primary key autoincrement, " +
            "username text, " +
            "sex text, " +
            "age text," +
            "health text," +
            "phonenumber text)";
    //员工表 id username sex age 
    public static final String createTable = "create table customer (" +
            "id integer primary key autoincrement, " +
            "username text, " +
            "sex text, " +
            "age text,"+
            "health text," +
            "phonenumber text)";

    //抽象类 必须定义显示的构造函数 重写方法
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        arg0.execSQL(createTableStu);
        arg0.execSQL(createTable);
        Toast.makeText(mContext, "Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        //  arg0.execSQL("drop table if exists Student");
        onCreate(arg0);
        Toast.makeText(mContext, "Upgraged", Toast.LENGTH_SHORT).show();
    }
}