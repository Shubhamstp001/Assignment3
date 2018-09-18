package com.shubham.myexpenses;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends Activity {

    MyHelper ob;
    SQLiteDatabase db;
    EditText et1,et2,et3,et4;
    Button button;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinup_activity);

        ob = new MyHelper(this);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);

        button = (Button) findViewById(R.id.btnsignup);

        rg = (RadioGroup) findViewById(R.id.rgroup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = ob.getWritableDatabase();
                String mob = et1.getText().toString();
                String pass = et2.getText().toString();
                String cpass = et3.getText().toString();
                String name = et4.getText().toString();
                String gender = rb.getText().toString();

                if (cpass.equals(pass)) {
                    db.execSQL("insert into signup(Mobile,Name,Password,Gender)values(" + mob + ",'" + name + "','" + pass + "','" + gender + "')");
                    Toast.makeText(getApplicationContext(),"Record Saved",Toast.LENGTH_LONG).show();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(3000);
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Password not matched",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void rbClick(View view)
    {
        int rbId = rg.getCheckedRadioButtonId();
        rb = (RadioButton)findViewById(rbId);
    }
}
