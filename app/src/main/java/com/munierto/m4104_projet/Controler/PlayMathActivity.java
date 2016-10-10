package com.munierto.m4104_projet.Controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.munierto.m4104_projet.R;

public class PlayMathActivity extends AppCompatActivity {

    public static final String PSEUDO = "pseudo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_math);
    }

    public void playMathLevel1 (View view){
        String pseudo = getIntent().getStringExtra(PlayActivity.PSEUDO);
        Intent intent = new Intent(this, PlayMathLevel1Activity.class);
        intent.putExtra(PSEUDO,pseudo);
        startActivity(intent);
    }

    public void playMathLevel2 (View view){
        String pseudo = getIntent().getStringExtra(PlayActivity.PSEUDO);
        Intent intent = new Intent(this, PlayMathLevel2Activity.class);
        intent.putExtra(PSEUDO,pseudo);
        startActivity(intent);
    }
}
