package com.mayur.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signinPage extends AppCompatActivity {
    private EditText etUser_name, etPhone, etPass1, etPass2;
    SharedPreferences shp;
    SharedPreferences.Editor myeditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin_page);
        Toast.makeText(this, "Welcome New User!!", Toast.LENGTH_LONG).show();





        etUser_name = findViewById(R.id.edittextUser);
        etPhone = findViewById(R.id.edittextPhone);
        etPass1 = findViewById(R.id.edittextPass1);
        etPass2 = findViewById(R.id.edittextPass2);
        etUser_name.setText("");
        etPhone.setText("");
        etPass1.setText("");
        etPass2.setText("");

        shp=getSharedPreferences("myPP",MODE_PRIVATE);

        CheckLogin();

    }

    public void RealRegister(View v) {
        if (etUser_name.getText().toString().equals("") || etPhone.getText().toString().equals("") || etPass1.getText().toString().equals("") || etPass2.getText().toString().equals(""))
           Toast.makeText(this,"Please insert all the fields !!",Toast.LENGTH_LONG).show();

        else
            DoLogin(etUser_name.getText().toString(),etPass1.getText().toString(), etPass2.getText().toString());


    }

    public void CheckLogin() {
        if (shp == null)
            shp = getSharedPreferences("myPP", MODE_PRIVATE);

        String userName = shp.getString("name", "");

        if (userName != null && !userName.equals("")) {
            Intent i = new Intent(signinPage.this, loginPage.class);
            startActivity(i);
            finish();
        }

    }

    public void DoLogin(String userid, String pass1, String pass2) {
        try {
            if (pass1.equals(pass2)) {
                if (shp == null)
                    shp = getSharedPreferences("myPP", MODE_PRIVATE);

                myeditor = shp.edit();
                myeditor.putString("name", userid);
                myeditor.putString("pass",pass1);
                myeditor.commit();

                Intent i = new Intent(signinPage.this, loginPage.class);
                startActivity(i);
                finish();
            } else
               Toast.makeText(this,"The password confirmation doesn't match !!",Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }













}

