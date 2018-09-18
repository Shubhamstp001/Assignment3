package com.shubham.myexpenses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class otp extends AppCompatActivity
{
    EditText t1,t2;
    Button btn1;
    SmsManager sm;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);
        t1=(EditText)findViewById(R.id.editText5);
        t2=(EditText)findViewById(R.id.editText6);
        btn1=(Button)findViewById(R.id.button2);
        sm=SmsManager.getDefault();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    String mob=t1.getText().toString();
                    String msg=t2.getText().toString();
                    sm.sendTextMessage(mob,null,msg,null,null);
                Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
            }
        });
    }
}
