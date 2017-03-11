package com.survey.wang.survey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import utils.SysApplication;
import utils.fileor;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SysApplication.getInstance().addActivity(this);
        Button btn_ques1=(Button)findViewById(R.id.btn_ques1);
        btn_ques1.setOnClickListener(new View.OnClickListener() {
        RadioGroup group=(RadioGroup)findViewById(R.id.ques1);
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int len = group.getChildCount(); // 获得单选按钮组的选项个数
                String msgString = ""; // 给选中的选项值赋值用的，初始化为空
                for (int i = 0; i < len; i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i); // 返回Group里的指定位置的视图(也就是按钮了)。
            /*
             * 查看android api 文档RadioButton的 public boolean isChecked
             * ()方法 如果未找到这个方法，往父类上找到，这个方法是用检测是否按钮被选中
             */
                    if (radioButton.isChecked()) {
                        msgString = radioButton.getText().toString();
                        break;
                    }
                }
                if(msgString!=""){
                    fileor.save(MainActivity.this,"1."+msgString+"|");
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, QuesActivity2.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please make your chioce", Toast.LENGTH_LONG).show();
                }

                //fileor.read(MainActivity.this);
                //Toast.makeText(MainActivity.this, msgString, Toast.LENGTH_LONG).show();

            }
        });
    }

}

