package com.munierto.m4104_projet.Controler;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.munierto.m4104_projet.Model.Question;
import com.munierto.m4104_projet.Model.QuestionDAO;
import com.munierto.m4104_projet.R;

import java.util.Random;

public class PlayGeneralCultutreActivity extends AppCompatActivity {

    public static final String PSEUDO = "pseudo";
    public static final String SCORE = "score";

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_general_cultutre);

        score = getIntent().getIntExtra(PlayActivity.SCORE, score);

        QuestionDAO questionDAO = new QuestionDAO(this);
        questionDAO.open();
        Question question = questionDAO.getQuestionRandom();
        questionDAO.close();

        TextView questionView = (TextView) findViewById(R.id.question);
        questionView.setText(question.getQuestion());

        final LinearLayout myLayout = (LinearLayout) findViewById(R.id.my_layout);

        Random rand = new Random();
            final int order = rand.nextInt(3)+1;

            /*LinearLayout ligne = new LinearLayout(this);
            ligne.setOrientation(LinearLayout.HORIZONTAL);*/
            final RadioGroup radioGroup = new RadioGroup(this);
            RadioButton radioButton = new RadioButton(this);
            //myLayout.addView(radioGroup);

            if (order==1) {
                radioButton.setText(question.getBonneReponse());
            }
            else if (order==2){
                radioButton.setText(question.getMauvaiseReponse1());
            }
            else if (order==3){
                radioButton.setText(question.getMauvaiseReponse1());
            }
            //ligne.addView(radioButton);
            //myLayout.addView(radioButton);
            radioGroup.addView(radioButton);

            /*ligne = new LinearLayout(this);
            ligne.setOrientation(LinearLayout.HORIZONTAL);*/
            radioButton = new RadioButton(this);
            if (order==1) {
                radioButton.setText(question.getMauvaiseReponse1());
            }
            else if (order==2){
                radioButton.setText(question.getBonneReponse());
            }
            else if (order==3){
                radioButton.setText(question.getMauvaiseReponse2());
            }
            //ligne.addView(radioButton);
            //myLayout.addView(radioButton);
            radioGroup.addView(radioButton);

            /*ligne = new LinearLayout(this);
            ligne.setOrientation(LinearLayout.HORIZONTAL);*/
            radioButton = new RadioButton(this);
            if (order==1) {
                radioButton.setText(question.getMauvaiseReponse2());
            }
            else if (order==2){
                radioButton.setText(question.getMauvaiseReponse2());
            }
            else if (order==3){
                radioButton.setText(question.getBonneReponse());
            }
            //ligne.addView(radioButton);
            //myLayout.addView(radioButton);
            radioGroup.addView(radioButton);

        myLayout.addView(radioGroup);

        Button button = new Button(this);
        button.setText("Valider");

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String pseudo = getIntent().getStringExtra(MenuActivity.PSEUDO);
                //Toast.makeText(PlayGeneralCultutreActivity.this, Integer.toString(radioGroup.getCheckedRadioButtonId()), Toast.LENGTH_LONG).show();
                if (((RadioButton)radioGroup.getChildAt(order-1)).isChecked()){
                    score++;
                    Intent intent = new Intent(PlayGeneralCultutreActivity.this, PlayGeneralCultutreActivity.class);
                    intent.putExtra(PSEUDO,pseudo);
                    intent.putExtra(SCORE, score);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(PlayGeneralCultutreActivity.this);
                    builder1.setMessage("Félicitations ! Votre score : "+score);
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

            }
        });

        myLayout.addView(button);
        Toast.makeText(PlayGeneralCultutreActivity.this, "Bravo ! Votre Score : "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }
}
