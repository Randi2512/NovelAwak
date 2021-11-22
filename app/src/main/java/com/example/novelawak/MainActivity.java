package com.example.novelawak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//    TextView txtData;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private final String TAG = "MainActivity";
    private List<Novel.Result> results = new ArrayList<>();
    BottomNavigationView bottomNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromApi();
        setupView();
        setupRecyclerView();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.beranda);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.beranda:
                        return true;
//                    case R.id.favorit:
//                        startActivity(new Intent(getApplicationContext(),
//                                FavoritActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(),
                                AkunActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void setupView() {
        recyclerView = findViewById(R.id.rv_data);

    }

    private void setupRecyclerView() {
        mainAdapter = new MainAdapter(results, new MainAdapter.OnAdapterListener() {
            @Override
            public void onClick(Novel.Result result) {
//                Toast.makeText(MainActivity.this, result.getJudul(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NovelDetailActivity.class);
                intent.putExtra("intent_judul",result.getJudul());
                intent.putExtra("intent_penerbit",result.getPenerbit());
                intent.putExtra("intent_penulis",result.getPenulis());
                intent.putExtra("intent_jml_halaman",result.getJml_halaman());
                intent.putExtra("intent_isbn",result.getISBN());
                intent.putExtra("intent_tahun_terbit",result.getTahun_terbit());
                intent.putExtra("intent_kategori",result.getKategori());
                intent.putExtra("intent_sinopsis",result.getSinopsis());
                intent.putExtra("intent_pdf",result.getUrl_file());
                intent.putExtra("intent_gambar",result.getUrl_gambar());
                startActivity(intent);

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    private void getDataFromApi() {

        ApiService.endpoint().getNovel()
                .enqueue(new Callback<Novel>() {
                    @Override
                    public void onResponse(Call<Novel> call, Response<Novel> response) {
//                        Log.d( TAG, response.toString());
                        if (response.isSuccessful()) {
                            List<Novel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            mainAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<Novel> call, Throwable t) {
                        Log.d( TAG, t.toString());

                    }
                });

    }
}
