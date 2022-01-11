package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.paymu.R;

public class RecoveryActivity extends AppCompatActivity {
    EditText Email3;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        Email3 = findViewById(R.id.email);
        back = findViewById(R.id.back);

        back.setOnClickListener(v -> {
            Intent i = new Intent(this, LoginActivity.class );
            startActivity(i);
        });

    }
}