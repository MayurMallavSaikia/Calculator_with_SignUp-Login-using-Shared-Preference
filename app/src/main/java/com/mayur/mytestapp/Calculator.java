package com.mayur.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private TextView tv;
    private EditText et1, et2;
    private Button btAdd, btSub, btMulti, btDiv;
    private String enter1, enter2, Anstext;
    private Double num1,num2, Ansval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_calculator);
        et1=findViewById(R.id.editTextFirst);
        et2=findViewById(R.id.editTextSecond);
        btAdd=findViewById(R.id.buttonADD);
        btDiv=findViewById(R.id.buttonDIV);
        btMulti=findViewById(R.id.buttonMULTI);
        btSub=findViewById(R.id.buttonSUB);
        tv=findViewById(R.id.textView1);




        btAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  enter1=et1.getText().toString();
                  enter2=et2.getText().toString();
                  num1=Double.parseDouble(enter1);
                  num2=Double.parseDouble(enter2);
                  Ansval=num1+num2;
                  Anstext=String.valueOf(Ansval);

                  tv.setText("Answer = "+Anstext);
              }
          });

          btSub.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  enter1=et1.getText().toString();
                  enter2=et2.getText().toString();
                  num1=Double.parseDouble(enter1);
                  num2=Double.parseDouble(enter2);
                  Ansval=num1-num2;
                  Anstext=String.valueOf(Ansval);
                  tv.setText("Answer = "+Anstext);

              }
          });

          btMulti.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  enter1=et1.getText().toString();
                  enter2=et2.getText().toString();
                  num1=Double.parseDouble(enter1);
                  num2=Double.parseDouble(enter2);
                  Ansval=num1*num2;
                  Anstext=String.valueOf(Ansval);
                  tv.setText("Answer = "+Anstext);
              }
          });

          btDiv.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  enter1=et1.getText().toString();
                  enter2=et2.getText().toString();
                  num1=Double.parseDouble(enter1);
                  num2=Double.parseDouble(enter2);
                  Ansval=num1/num2;
                  Anstext=String.valueOf(Ansval);
                      tv.setText("Answer = "+Anstext);
                  }
          });


    }
}