package com.example.novelawak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class NovelDetailActivity extends AppCompatActivity {


    private final String TAG = "DetailActivity";
    TextView txtJudul,txtPenerbit,txtPenulis,txtJmlHalaman,
            txtIsbn,txtTahun,txtKategori,txtSinopsis;
    ImageView imageView;
    Button btnPdf;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_detail);

        txtJudul = findViewById(R.id.txtJudulBuku);
        txtPenerbit = findViewById(R.id.txtPenerbit);
        txtPenulis = findViewById(R.id.txtPenulis);
        txtJmlHalaman = findViewById(R.id.txtJmlHalaman);
//        txtIsbn = findViewById(R.id.txt);
        txtPenerbit = findViewById(R.id.txtPenerbit);
        txtTahun = findViewById(R.id.txtTahunTerbit);
        txtKategori = findViewById(R.id.txtKategori);
        txtSinopsis = findViewById(R.id.txtSinopsis);

        btnPdf=findViewById(R.id.btnPdf);

        imageView=findViewById(R.id.imageNovel);

        String judul = getIntent().getStringExtra("intent_judul");
        String gambar = getIntent().getStringExtra("intent_gambar");
        String penerbit = getIntent().getStringExtra("intent_penerbit");
        String penulis = getIntent().getStringExtra("intent_penulis");
        String jml_halaman = getIntent().getStringExtra("intent_jml_halaman");
        String isbn = getIntent().getStringExtra("intent_isbn");
        String tahun_terbit = getIntent().getStringExtra("intent_tahun_terbit");
        String kategori = getIntent().getStringExtra("intent_kategori");
        String sinopsis = getIntent().getStringExtra("intent_sinopsis");
        String pdf = getIntent().getStringExtra("intent_pdf");
        getSupportActionBar().setTitle(judul);
        txtJudul.setText("" +judul);
        txtPenerbit.setText(" " +penerbit);
        txtPenulis.setText(" By " +penulis);
        txtJmlHalaman.setText(" " +jml_halaman);
//        txtIsbn.setText("ISBN     : " +isbn);
        txtTahun.setText(" " +tahun_terbit);
        txtKategori.setText(" " +kategori);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txtSinopsis.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }
        txtSinopsis.setText(""+sinopsis);

        Picasso.get().load(gambar).into(imageView);

        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NovelDetailActivity.this, PdfActivity.class);
                intent.putExtra("intent_pdf",pdf);
                startActivity(intent);

            }
        });
//        Log.d(TAG, judul);




    }
}
