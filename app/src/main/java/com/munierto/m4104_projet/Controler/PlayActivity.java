package com.munierto.m4104_projet.Controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.munierto.m4104_projet.R;

public class PlayActivity extends AppCompatActivity {

    public static final String PSEUDO = "pseudo";
    public static final String SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void playMath (View view){
        String pseudo = getIntent().getStringExtra(MenuActivity.PSEUDO);
        Intent intent = new Intent(this, PlayMathActivity.class);
        intent.putExtra(PSEUDO,pseudo);
        startActivity(intent);
    }

    public void playGeneralCultutre (View view){
        String pseudo = getIntent().getStringExtra(MenuActivity.PSEUDO);
        int score = 0;
        Intent intent = new Intent(this, PlayGeneralCultutreActivity.class);
        intent.putExtra(PSEUDO,pseudo);
        intent.putExtra(SCORE, score);
        startActivity(intent);
    }
}
