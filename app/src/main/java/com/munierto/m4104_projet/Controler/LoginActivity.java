package com.munierto.m4104_projet.Controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.munierto.m4104_projet.Model.User;
import com.munierto.m4104_projet.Model.UserDAO;
import com.munierto.m4104_projet.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public static final String PSEUDO = "pseudo";

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserDAO userDAO = new UserDAO(this);
        userDAO.open();
        users = userDAO.getUsers();
        userDAO.close();

        //Affichage des users
        Button userView = (Button)findViewById(R.id.button1);
        userView.setText(users.get(0).getPseudo());

        Button userView2 = (Button)findViewById(R.id.button2);
        userView2.setText(users.get(1).getPseudo());

    }

    public void signIn(View view) {
        //EditText editText = (EditText) findViewById(R.id.pseudo);
        //String pseudo = editText.getText().toString();
        String pseudo = (String) ((Button) view).getText();
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(PSEUDO,pseudo);
        startActivity(intent);
    }
}
