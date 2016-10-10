package com.munierto.m4104_projet.Model;
//import java.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by -Toshiba- on 27/09/2016.
 */
public class UserDAO extends DAOBase {

    //Nom de la table
    public static final String TABLE_USER = "USER";

    //Table : User
    public static final String COL_PSEUDO = "pseudo";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";
    public static final String COL_LEVELMATH = "levelMath";
    public static final String COL_BESTSCORECULTURE = "bestScoreCulture";
    public static final String COL_AVATAR = "avatar";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COL_PSEUDO + " TEXT NOT NULL PRIMARY KEY, " +
                    COL_NOM + " TEXT NOT NULL, " +
                    COL_PRENOM + " TEXT NOT NULL, " +
                    COL_LEVELMATH + " INTEGER, " +
                    COL_BESTSCORECULTURE + " INTEGER, " +
                    COL_AVATAR + " TEXT NOT NULL);";

    // Données pour la table
    private static final String[] DATA = new String[] {
            "'munierto', 'Munier', 'Tom', '0', '0', 'avatar'",
            "'adlit', 'Adli', 'Thafsouth', '0', '0', 'avatar'"};

    // retourne une liste de chaînes de caractères représentant les instructions SQL d'insertion de données dans la table
    public static String[] getInsertSQL() {
        String insertSQL = "INSERT INTO " + TABLE_USER + "("
                + COL_PSEUDO + ", "
                + COL_NOM + ", "
                + COL_PRENOM + ", "
                + COL_LEVELMATH + ", "
                + COL_BESTSCORECULTURE + ", "
                + COL_AVATAR + ") VALUES ";

        //
        String[] liste = new String[DATA.length];
        int i = 0;
        for (String user : DATA) {

            // Instruction SQL INSERT
            liste[i] = insertSQL + "(" + user + ")";
            i++;
        }

        //
        return liste;
    }

    public UserDAO(Context context) {
        super(context);
    }

    public ArrayList<User> getUsers(){
        Cursor cursor = getDB().rawQuery("SELECT * FROM " + TABLE_USER + " ORDER BY " + COL_PSEUDO, null);
        return cursorToListUser(cursor);
    }

    public ArrayList<User> cursorToListUser(Cursor cursor){
        // Récupére l'index des champs
        int indexPseudo = cursor.getColumnIndex(COL_PSEUDO);
        int indexNom = cursor.getColumnIndex(COL_NOM);
        int indexPrenom = cursor.getColumnIndex(COL_PRENOM);
        int indexLevelMath = cursor.getColumnIndex(COL_LEVELMATH);
        int indexBestScoreCultutre = cursor.getColumnIndex(COL_BESTSCORECULTURE);
        int indexAvatar = cursor.getColumnIndex(COL_AVATAR);

        // Declaration et initialisation d'une liste d'utilisateurs
        ArrayList<User> liste = new ArrayList<>();

        while (cursor.moveToNext()) {

            // Création d'un utilisateur
            User user = new User();
            user.setPseudo(cursor.getString(indexPseudo));
            user.setNom(cursor.getString(indexNom));
            user.setPrenom(cursor.getString(indexPrenom));
            user.setLevelMath(cursor.getInt(indexLevelMath));
            user.setBestScoreCulture(cursor.getInt(indexBestScoreCultutre));
            user.setAvatar(cursor.getString(indexAvatar));

            // Ajout dans la liste
            liste.add(user);
        }

        // Fermeture du cursor
        cursor.close();

        //
        return liste;
    }


    public long insert(User user){
        ContentValues values = new ContentValues();

        values.put(COL_PSEUDO, user.getPseudo());
        values.put(COL_NOM, user.getNom());
        values.put(COL_PRENOM, user.getPrenom());
        values.put(COL_LEVELMATH, user.getLevelMath());
        values.put(COL_BESTSCORECULTURE, user.getBestScoreCulture());
        values.put(COL_AVATAR, user.getAvatar());

        return getDB().insert(TABLE_USER,null,values);
    }

    public int update(User user) {

        // Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        // Ajout clé/valeur : colonne/valeur
        values.put(COL_LEVELMATH, user.getLevelMath());
        values.put(COL_BESTSCORECULTURE, user.getBestScoreCulture());

        // Insertion de l'objet dans la BD via le ContentValues et l'identifiant
        return getDB().update(TABLE_USER, values, COL_PSEUDO + " = " + user.getPseudo(), null);
    }

    public User retrieveByID (String pseudo){
        Cursor cursor = getDB().rawQuery(
                "SELECT * FROM " + TABLE_USER
                + " WHERE " + COL_PSEUDO + "="+pseudo, new String[]{}
        );
        return cursorToFirstUser(cursor) ;
    }

    private User cursorToFirstUser(Cursor cursor) {
        int indexPseudo = cursor.getColumnIndex(COL_PSEUDO);
        int indexNom = cursor.getColumnIndex(COL_NOM);
        int indexPrenom = cursor.getColumnIndex(COL_PRENOM);
        int indexLevelMath = cursor.getColumnIndex(COL_LEVELMATH);
        int indexBestScoreCulture = cursor.getColumnIndex(COL_BESTSCORECULTURE);
        int indexAvatar = cursor.getColumnIndex(COL_AVATAR);

        User user = null ;

        if(cursor.getCount()>0){

            cursor.moveToFirst();

            user = new User(cursor.getString(indexPseudo),cursor.getString(indexNom),cursor.getString(indexPrenom),cursor.getInt(indexLevelMath),cursor.getInt(indexBestScoreCulture)) ;
        }
        cursor.close();

        return user;
    }

}
