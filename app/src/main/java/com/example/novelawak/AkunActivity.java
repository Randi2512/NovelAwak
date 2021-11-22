package com.example.novelawak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AkunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        TextView txtakun = findViewById(R.id.txtAkun);

        bottomNavigationView.setSelectedItemId(R.id.akun);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
//                    case R.id.favorit:
//                        startActivity(new Intent(getApplicationContext(),
//                                AkunActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.akun:
                        return true;
                }
                return false;
            }
        });

    }
}
