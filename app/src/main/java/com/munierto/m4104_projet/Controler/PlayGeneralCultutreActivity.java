package com.munierto.m4104_projet.Controler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.munierto.m4104_projet.R;

public class PlayGeneralCultutreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_general_cultutre);

        final LinearLayout myLayout = (LinearLayout) findViewById(R.id.myLayout);
    }
}
