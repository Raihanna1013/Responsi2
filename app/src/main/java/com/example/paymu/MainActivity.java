package com.example.paymu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paymu.UI.Fragment.HistoryFragmen;
import com.example.paymu.UI.Fragment.HomeFrgament;
import com.example.paymu.UI.Fragment.PaymentFragment;
import com.example.paymu.UI.Fragment.SettingFragment;
import com.example.paymu.UI.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnav);
        toolbar = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFrgament()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new HomeFrgament();
                    break;

                case R.id.payment:
                    fragment = new PaymentFragment();
                    break;
                case R.id.History:
                    fragment = new HistoryFragmen();
                    break;
                case R.id.Setting:
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

            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(this, "LOG-OUT Berhasil!!!", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}