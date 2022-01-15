package com.example.paymu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.paymu.UI.Fragment.HistoryFragmen;
import com.example.paymu.UI.Fragment.HomeFrgament;
import com.example.paymu.UI.Fragment.Payment;
import com.example.paymu.UI.Fragment.SettingFragment;
import com.example.paymu.UI.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Session session;
    Toolbar toolbar;
    TextView tvnama;
    @SuppressLint("NonConstantResouceId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnav);
        toolbar = findViewById(R.id.toolbar2);
        tvnama = findViewById(R.id.tvname);
        session = new Session(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(session.loggedin()){
            String name = getIntent().getStringExtra("name");
            tvnama.setText(name);
    }
        String name = getIntent().getStringExtra("name");
        tvnama.setText(name);
        session.setLoggedin(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFrgament()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menu:
                    fragment = new HomeFrgament();
                    break;

                case R.id.payment:
                    fragment = new Payment();
                    break;
                case R.id.history:
                    fragment = new HistoryFragmen();
                    break;
                case R.id.setting:
                    fragment = new SettingFragment();
                    break;
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout1) {
            session.setLoggedin(false);
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(this, "LOG-OUT Berhasil!!!", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}