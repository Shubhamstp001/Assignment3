package com.shubham.myexpenses;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    EditText t1,t2;
    Button btn1;
    MyHelper ob;
    SQLiteDatabase db;
    Cursor cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ob=new MyHelper(this);
        t1=(EditText)findViewById(R.id.editText4);
        t2=(EditText)findViewById(R.id.editText5);
        btn1=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=ob.getReadableDatabase();
                String mob=t1.getText().toString();
                String psw=t2.getText().toString();
                cr=db.rawQuery("select * from signup where Mobile='" + mob + "' and Password='" + psw +"'",null);
                if(cr.moveToNext())
                {
                    Intent ob1=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(ob1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid  Mobile/Password", Toast.LENGTH_SHORT).show();
                }
                cr.close();
            }
        });
    }
}
