package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paymu.MainActivity;
import com.example.paymu.R;

public class LoginActivity extends AppCompatActivity {

    TextView tvreg, tvpas1;
    EditText etmail, etpas;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

    }
}