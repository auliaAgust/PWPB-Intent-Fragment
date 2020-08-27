package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button exp;
    Button imp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exp = (Button)findViewById(R.id.exp_intent);
        exp.setOnClickListener(this);
        imp = (Button)findViewById(R.id.imp_intent);
        imp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exp_intent:
                Intent ep = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(ep);
                break;
            case R.id.imp_intent:
                Intent im = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.w3schools.com"));
                startActivity(im);
                break;
            default:
                break;
        }
    }
}
