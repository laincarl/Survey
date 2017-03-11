package com.survey.wang.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.SysApplication;
import utils.fileor;

/**
 * Created by wang on 2017/3/11.
 */

public class QuesActivity12 extends AppCompatActivity {

    String address="";
    EditText email;
    int flage=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ques_12);
        SysApplication.getInstance().addActivity(this);
        email=(EditText)findViewById(R.id.email);
        Button btn_ques12=(Button)findViewById(R.id.btn_ques12);
        Button btn_exit=(Button)findViewById(R.id.btn_exit);
        btn_ques12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                address=email.getText().toString();
                if(isEmail(address)){
                    fileor.save(QuesActivity12.this,"12."+address);
                    //fileor.read(QuesActivity12.this);
                    Toast.makeText(QuesActivity12.this, "save success!", Toast.LENGTH_LONG).show();
                    flage=1;
                }
                else{
                    Toast.makeText(QuesActivity12.this, "Please input correct email address!", Toast.LENGTH_LONG).show();
                }
                //Intent intent = new Intent();
               // intent.setClass(QuesActivity12.this, QuesActivity12.class);
                //startActivity(intent);


            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(flage==1){

                    SysApplication.getInstance().exit();

                }
                else{
                    Toast.makeText(QuesActivity12.this, "Please save first!", Toast.LENGTH_LONG).show();
                }



            }
        });
    }
    //判断email格式是否正确
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

}


