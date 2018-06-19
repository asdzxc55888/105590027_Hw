package com.marriagesuggestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText Sex;
    EditText Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Age = (EditText)findViewById(R.id.edtAge);
        Sex = (EditText)findViewById(R.id.edtSex);
        final TextView Output = (TextView)findViewById(R.id.txtR);
        Button submit = (Button)findViewById(R.id.btnOK); // 取得按鈕物件

        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {

                if ( !("".equals(Age.getText().toString())
                        || "".equals(Sex.getText().toString())) )
                {
                    float fAge = Float.parseFloat(Age.getEditableText().toString());
                    if("male".equals(Sex.getEditableText().toString())){
                        if(fAge<30){
                            Output.setText("not hurry");
                        }else if(fAge>35){
                            Output.setText("find couple");
                        }else{
                            Output.setText("get marry");
                        }
                    }else if("female".equals(Sex.getEditableText().toString())){
                        if(fAge<28){
                            Output.setText("not hurry");
                        }else if(fAge>32){
                            Output.setText("find couple");
                        }else{
                            Output.setText("get marry");
                        }
                    }else{
                        Output.setText("輸入錯誤");
                    }
                }else {
                    Output.setText("尚未輸入資料");
                }


            }
        });
    }
}
