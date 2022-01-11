package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.paymu.MainActivity;
import com.example.paymu.R;

public class LoginActivity extends AppCompatActivity {

    EditText Email, Password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.btnlogin);

        Login.setOnClickListener(v -> {
           Intent i = new Intent(this, MainActivity.class);
           startActivity(i);
        });

    }
}