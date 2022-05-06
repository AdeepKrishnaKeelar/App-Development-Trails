package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button LoginBtn;
    int count=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText=findViewById(R.id.emaileditText1);
        passwordEditText=findViewById(R.id.passeditText1);
        LoginBtn=findViewById(R.id.button2);
        String registered_email=getIntent().getStringExtra("email");
        String registered_password=getIntent().getStringExtra("password");
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(registered_email.equals(email)&&registered_password.equals(password)) {
                    Intent i=new Intent(LoginActivity.this,LoginSuccess.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials!",Toast.LENGTH_LONG).show();
                    count--;
                    if(count==0) {
                        Toast.makeText(LoginActivity.this,"You took way too many tries!",Toast.LENGTH_LONG).show();
                        LoginBtn.setEnabled(false);
                    }
                }
            }
        });
    }
}