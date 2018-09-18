package com.shubham.myexpenses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper
{
    static final String dbname="mydatabase.db";
    static final int ver=1;
    public MyHelper(Context c)
    {
        super(c,dbname,null,ver);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table signup(Mobile integer primary key,Name text,Password text,Gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
