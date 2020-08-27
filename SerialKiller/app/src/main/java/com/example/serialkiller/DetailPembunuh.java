package com.example.serialkiller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailPembunuh extends AppCompatActivity {
    public static ArrayList<Killers> dataKiller ;
    public static String EXTRA_FOTO = "extra_foto";
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DETAIL = "extra_detail";
    public  static String EXTRA_BIO = "extra_bio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembunuh);

//        rvDetail = findViewById(R.id.rv_detail);
//        rvDetail.setHasFixedSize(true);
//        rvDetail.setLayoutManager(new LinearLayoutManager(this));
//        DetailAdapter detail = new DetailAdapter(this.dataKiller);
//        rvDetail.setAdapter(detail);

        TextView namaDiterima = findViewById(R.id.tv_nama);
        ImageView foto = findViewById(R.id.foto_pelaku);
        TextView detail = findViewById(R.id.tv_det_pem);
        TextView bio = findViewById(R.id.tv_bio_pem);


//        String nama = getIntent().getStringExtra(EXTRA_NAME);
//        int poto = getIntent().getIntExtra(EXTRA_FOTO, 0);

        namaDiterima.setText(getIntent().getStringExtra(EXTRA_NAME));
        foto.setImageResource(getIntent().getIntExtra(EXTRA_FOTO, 0));
        detail.setText(getIntent().getStringExtra(EXTRA_DETAIL));
        bio.setText(getIntent().getStringExtra(EXTRA_BIO));


    }


}