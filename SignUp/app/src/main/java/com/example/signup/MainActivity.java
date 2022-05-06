package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button SignUpBtn;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.PasseditText);
        SignUpBtn=findViewById(R.id.button);
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(!isValidPassword(password)) {
                    Toast.makeText(MainActivity.this,"Password does not clear the defined rules",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                i.putExtra("email",email);
                i.putExtra("password",password);
                startActivity(i);
            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern special_character=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password) {
        if(password.length()<8) {
            return false;
        } if(!lowercase.matcher(password).matches()) {
            return false;
        } if(!uppercase.matcher(password).matches()) {
            return false;
        } if(!number.matcher(password).matches()) {
            return false;
        } if(!special_character.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}