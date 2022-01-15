package com.example.paymu.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paymu.MainActivity;
import com.example.paymu.R;

public class PaymentActivity extends AppCompatActivity {

    TextView titel;
    ImageView back;
    EditText code;
    Button pay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        titel = findViewById(R.id.title);
        back = findViewById(R.id.back_icon);
        code = findViewById(R.id.Code);
        titel.setText("Payment");
        preferences = getSharedPreferences("User", 0);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("fragmentNumber", 2);
            startActivity(intent);
        });

        pay.setOnClickListener(v -> {
            String inputcode = code.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("code", inputcode);
            editor.apply();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("fragmentNumber",2);
            startActivity(intent);
        });
    }
}