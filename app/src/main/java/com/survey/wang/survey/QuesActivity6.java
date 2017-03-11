package com.survey.wang.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import utils.SysApplication;
import utils.fileor;

/**
 * Created by wang on 2017/3/11.
 */

public class QuesActivity6 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ques_6);
        SysApplication.getInstance().addActivity(this);
        Button btn_ques6=(Button)findViewById(R.id.btn_ques6);
        btn_ques6.setOnClickListener(new View.OnClickListener() {
            RadioGroup group=(RadioGroup)findViewById(R.id.ques6);
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int len = group.getChildCount(); // 获得单选按钮组的选项个数
                String msgString = ""; // 给选中的选项值赋值用的，初始化为空
                for (int i = 0; i < len; i++) {
                    CheckBox checkbox = (CheckBox) group.getChildAt(i); // 返回Group里的指定位置的视图(也就是按钮了)。
            /*
             * 查看android api 文档RadioButton的 public boolean isChecked
             * ()方法 如果未找到这个方法，往父类上找到，这个方法是用检测是否按钮被选中
             */
                    if (checkbox.isChecked()) {
                        msgString = msgString+"&"+checkbox.getText().toString();

                    }
                }
                if(msgString!=""){
                    fileor.save(QuesActivity6.this,"6."+msgString+"|");
                    Intent intent = new Intent();
                    intent.setClass(QuesActivity6.this, QuesActivity7.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(QuesActivity6.this, "Please make your chioce", Toast.LENGTH_LONG).show();
                }
                //fileor.read(MainActivity.this);
                //Toast.makeText(MainActivity.this, msgString, Toast.LENGTH_LONG).show();

            }
        });
    }

}


