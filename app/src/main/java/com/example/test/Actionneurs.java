package com.example.test;

import  androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Actionneurs extends MainActivity {

    View background, buttonPompeOn, buttonPompeOff, buttonPompeAirOn, buttonPompeAirOff;
    private ImageView aziz, backArrow;
    private Button btnPompeOn, btnPompeOff, btnPompeAirOn, btnPompeAirOff;
    private TextView pompeEau, pompeAir;
    String ip, url;
    private int peroupa = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionneurs);

        this.backArrow = (ImageView) findViewById(R.id.backArrow3);
        this.aziz = (ImageView) findViewById(R.id.lumiere);

        this.btnPompeOn = (Button) findViewById(R.id.btnPompeOn);
        this.btnPompeOff = (Button) findViewById(R.id.btnPompeOff);
        this.btnPompeAirOn = (Button) findViewById(R.id.btnPompeAirOn);
        this.btnPompeAirOff = (Button) findViewById(R.id.btnPompeAirOff);

        this.pompeEau = (TextView) findViewById(R.id.pompeEau);
        this.pompeAir = (TextView) findViewById(R.id.pompeAir);

        background = findViewById(R.id.actionneursxml);
        buttonPompeOn = findViewById(R.id.btnPompeOn);
        buttonPompeOff = findViewById(R.id.btnPompeOff);
        buttonPompeAirOn = findViewById(R.id.btnPompeAirOn);
        buttonPompeAirOff = findViewById(R.id.btnPompeAirOff);

        ip = readData();
        ip = ip.replaceAll("\\s",""); //Permet de supprimer l'espace crée à la fin du fichier texte à la lecture de ce dernier

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuuuActivity = new Intent(getApplicationContext(), Menu.class);
                startActivity(menuuuActivity);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        aziz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (peroupa % 2 == 0 && peroupa != 0)
                {
                    aziz.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    backArrow.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));

                    pompeEau.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    pompeAir.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                    btnPompeOn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
                    btnPompeOff.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
                    btnPompeAirOn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
                    btnPompeAirOff.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));

                    background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.background_grey));

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    url = "http://"+ ip +":8080/monitor/actionneurs/lumiere/on";

                    StringRequest lumiereOn = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Et la lumière fut", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                    queue.add(lumiereOn);
                }
                else
                {
                    aziz.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.background_grey));
                    backArrow.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.background_grey));

                    pompeEau.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.background_grey));
                    pompeAir.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.background_grey));

                    btnPompeOn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_200));
                    btnPompeOff.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_200));
                    btnPompeAirOn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_200));
                    btnPompeAirOff.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_200));

                    background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    url = "http://"+ ip +":8080/monitor/actionneurs/lumiere/off";

                    StringRequest lumiereOff = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), "Light off", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                    queue.add(lumiereOff);
                }
                peroupa ++;
            }
        });

        btnPompeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/arrosage/on";

                StringRequest arrosageOn = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Eau", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(arrosageOn);

                buttonPompeOn.setVisibility(View.INVISIBLE);
                buttonPompeOff.setVisibility(View.VISIBLE);
            }
        });

        btnPompeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/arrosage/off";

                StringRequest arrosageOff = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Eau", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(arrosageOff);

                buttonPompeOff.setVisibility(View.INVISIBLE);
                buttonPompeOn.setVisibility(View.VISIBLE);
            }
        });

        btnPompeAirOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/air/on";

                StringRequest airOn = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Vacuum", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(airOn);

                buttonPompeAirOn.setVisibility(View.INVISIBLE);
                buttonPompeAirOff.setVisibility(View.VISIBLE);
            }
        });

        btnPompeAirOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/air/off";

                StringRequest airOff = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Vent", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(airOff);

                buttonPompeAirOff.setVisibility(View.INVISIBLE);
                buttonPompeAirOn.setVisibility(View.VISIBLE);
            }
        });

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent menuActivity = new Intent(getApplicationContext(), Menu.class);
            startActivity(menuActivity);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
}