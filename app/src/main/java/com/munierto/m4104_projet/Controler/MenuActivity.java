package com.munierto.m4104_projet.Controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.munierto.m4104_projet.R;

public class MenuActivity extends AppCompatActivity {

    public static final String PSEUDO = "pseudo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String pseudo = getIntent().getStringExtra(LoginActivity.PSEUDO);
    }

    public void play (View view){
        String pseudo = getIntent().getStringExtra(LoginActivity.PSEUDO);
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra(PSEUDO,pseudo);
        startActivity(intent);
    }
}
