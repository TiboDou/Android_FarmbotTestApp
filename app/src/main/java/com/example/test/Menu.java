package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu extends MainActivity {

    private Button deplacement, lumiere, outils;
    private ImageView backArrow;
    private TextView affichageIP;
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuuu);

        this.deplacement = (Button) findViewById(R.id.deplacement);
        this.lumiere = (Button) findViewById(R.id.actionneurs);
        this.outils = (Button) findViewById(R.id.outils);
        this.backArrow = (ImageView) findViewById(R.id.backArrow);
        this.affichageIP = (TextView) findViewById(R.id.affichageIP);

        ip = readData();
        ip = ip.replaceAll("\\s","");
        affichageIP.setText("Adresse IP : " + ip);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        deplacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deplacementsActivity = new Intent(getApplicationContext(), Deplacements.class);
                startActivity(deplacementsActivity);
                finish();
        }
        });

        lumiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lumiereActivity = new Intent(getApplicationContext(), Actionneurs.class);
                startActivity(lumiereActivity);
                finish();
            }
        });

        outils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outilsActivity = new Intent(getApplicationContext(), Outils.class);
                startActivity(outilsActivity);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

