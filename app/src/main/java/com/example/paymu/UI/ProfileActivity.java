package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paymu.MainActivity;
import com.example.paymu.R;

public class ProfileActivity extends AppCompatActivity {
    Button save;
    ImageView back;
    TextView titel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back = findViewById(R.id.back_icon);
        save = findViewById(R.id.btnsave);
        titel = findViewById(R.id.title);

        titel.setText("Profile");

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        save.setOnClickListener(v -> {
            Toast.makeText(this, "Profile Tersimpan", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}