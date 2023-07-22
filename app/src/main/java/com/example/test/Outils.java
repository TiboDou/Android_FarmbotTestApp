package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Outils extends MainActivity {

    ImageView backArrow4;
    Button outil1_prendre, outil1_deposer, outil2_prendre, outil2_deposer, outil3_prendre, outil3_deposer;
    String ip, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outils);

        this.backArrow4 = (ImageView) findViewById(R.id.backArrow4);

        this.outil1_prendre = (Button) findViewById(R.id.outil1_prendre);
        this.outil1_deposer = (Button) findViewById(R.id.outil1_deposer);
        this.outil2_prendre = (Button) findViewById(R.id.outil2_prendre);
        this.outil2_deposer = (Button) findViewById(R.id.outil2_deposer);
        this.outil3_prendre = (Button) findViewById(R.id.outil3_prendre);
        this.outil3_deposer = (Button) findViewById(R.id.outil3_deposer);

        ip = readData();
        ip = ip.replaceAll("\\s","");

        backArrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuuu = new Intent(getApplicationContext(), Menu.class);
                startActivity(menuuu);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        /*  =================================================================================
            ====================  Intéractions avec l'outil N°1 : Désherbeur  ===============
            ================================================================================= */

        outil1_prendre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/desherbeur/prendre";

                StringRequest prendre_outil1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Prendre outil 1", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(prendre_outil1);
            }
        });


        outil1_deposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/desherbeur/deposer";

                StringRequest deposer_outil1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Déposer outil 1", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(deposer_outil1);
            }
        });

        /*  =================================================================================
            ===================== Intéractions avec l'outil N°2 : Semeur ====================
            ================================================================================= */

        outil2_prendre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/semeur/prendre";

                StringRequest prendre_outil2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Prendre outil 2", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(prendre_outil2);
            }
        });

        outil2_deposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/semeur/deposer";

                StringRequest deposer_outil2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Déposer outil 2", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(deposer_outil2);
            }
        });

        /*  =================================================================================
            ==================   Intéractions avec l'outil N°3 : Scanner ====================
            ================================================================================= */

        outil3_prendre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/arroseur/prendre";

                StringRequest prendre_outil3 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Prendre outil 3", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(prendre_outil3);
            }
        });

        outil3_deposer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/actionneurs/arroseur/deposer";

                StringRequest deposer_outil3 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Déposer outil 3", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(deposer_outil3);
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