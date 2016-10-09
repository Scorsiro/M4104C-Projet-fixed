package com.munierto.m4104_projet.Controler;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.munierto.m4104_projet.R;

import java.util.Random;

public class PlayMathLevel2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_math_level2);

        final LinearLayout myLayout = (LinearLayout) findViewById(R.id.myLayout);
        Random rand = new Random();
        final int res[] = new int[9];
        for (int i=0; i<9; i++){

            int x = rand.nextInt(8)+1;
            int y = rand.nextInt(x);
            res[i] = x-y;

            LinearLayout ligne = new LinearLayout(this);
            ligne.setOrientation(LinearLayout.HORIZONTAL);
            //ligne.setLayoutParams(new LinearLayout.LayoutParams(1000, LinearLayout.LayoutParams.WRAP_CONTENT));


            TextView operation = new TextView(this);
            operation.setText(x+" - "+y+" = ");
            ligne.addView(operation);

            EditText result = new EditText(this);
            result.setWidth(200);
            result.setInputType(InputType.TYPE_CLASS_NUMBER);
            ligne.addView(result);

            ImageView img = new ImageView(this);
            img.setVisibility(View.INVISIBLE);
            //img.setImageResource(R.drawable.check_vert);
            ligne.addView(img);

            myLayout.addView(ligne);
        }
        Button button = new Button(this);
        button.setText("Valider");
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int resUser[] = new int[9];
                int score = 0;
                boolean error = false;
                try {
                    for (int i = 0; i < 9; i++) {
                        LinearLayout ligne = (LinearLayout) myLayout.getChildAt(i); // La ligne i
                        EditText result = (EditText) ligne.getChildAt(1); // Le résultat de l'utilisateur
                        resUser[i] = Integer.parseInt(result.getText().toString());
                        /*ImageView checkRes = ((ImageView) ligne.getChildAt(2));
                        if (res[i] == resUser[i]) {
                            checkRes.setImageResource(R.drawable.check_vert);
                            score++;
                        } else {
                            checkRes.setImageResource(R.drawable.check_rouge);
                        }
                        checkRes.setVisibility(View.VISIBLE);*/
                    }
                    //Toast.makeText(PlayMathLevel2Activity.this, "Votre score : " + score + "/9", Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    //Toast.makeText(PlayMathLevel2Activity.this, "Erreur", Toast.LENGTH_LONG).show();
                    error = true;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(PlayMathLevel2Activity.this);
                    builder1.setMessage("Remplissez tous les champs");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                if (!error) {
                    for (int i = 0; i < 9; i++) {
                        LinearLayout ligne = (LinearLayout) myLayout.getChildAt(i); // La ligne i

                        ImageView checkRes = ((ImageView) ligne.getChildAt(2));
                        if (res[i] == resUser[i]) {
                            checkRes.setImageResource(R.drawable.check_vert);
                            score++;
                        } else {
                            checkRes.setImageResource(R.drawable.check_rouge);
                        }
                        checkRes.setVisibility(View.VISIBLE);
                    }
                    Toast.makeText(PlayMathLevel2Activity.this, "Votre score : " + score + "/9", Toast.LENGTH_LONG).show();
                }
            }
        });

        myLayout.addView(button);
    }
}