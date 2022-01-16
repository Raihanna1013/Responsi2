package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.paymu.MainActivity;
import com.example.paymu.R;

import java.text.CollationElementIterator;

public class Registrasi_Activity extends AppCompatActivity {
    Button registrasi;
    EditText Email2, Telepon, Password2;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        Email2 = findViewById(R.id.email);
        Password2 = findViewById(R.id.password);
        Telepon = findViewById(R.id.telepon);
        registrasi = findViewById(R.id.btnRegistrasi);
        back = findViewById(R.id.back);


        back.setOnClickListener(v -> {
            Intent i = new Intent(this, LoginActivity.class );
            startActivity(i);
        });

        registrasi.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

    }
}
