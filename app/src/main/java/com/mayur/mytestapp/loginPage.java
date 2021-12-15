package com.mayur.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private String userName, passWord;
    SharedPreferences shp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_page);

        etUsername=findViewById(R.id.editTextUsername);
        etPassword=findViewById(R.id.editTextPassword);

        shp=getSharedPreferences("myPP",MODE_PRIVATE);

        CheckLogin();

    }


    public void CheckLogin() {
        if (shp == null)
            shp = getSharedPreferences("myPP", MODE_PRIVATE);


        userName = shp.getString("name", "");
        passWord=shp.getString("pass","");

        if (userName != null && !userName.equals("") && passWord !=null && !passWord.equals("")) {
            Toast.makeText(getApplicationContext(),"Welcome "+userName,Toast.LENGTH_LONG).show();

        } 
    }





    public void goRegister(View v){
        Intent i =new Intent(loginPage.this,signinPage.class);
        startActivity(i);
        finish();
    }

    public void haveAccess(View v){
        String loginUser=etUsername.getText().toString();
        String loginPass=etPassword.getText().toString();

        if(loginUser.isEmpty() || loginPass.isEmpty())
            Toast.makeText(getApplicationContext(),"All fields are mandatory !!",Toast.LENGTH_LONG).show();


        else if(loginUser.equals(userName) && loginPass.equals(passWord))
        {
            Intent i=new Intent(loginPage.this, Calculator.class);
            startActivity(i);
        }
        else
            Toast.makeText(this,"Invalid Credential !! Enter again!!",Toast.LENGTH_LONG).show();

    }
}