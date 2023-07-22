package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

public class Deplacements extends MainActivity {

    private ImageView y_up1, y_down1, x_left1, x_right1, z_up1, z_down1, backArrow2;
    private TextView pos_X, pos_Y, pos_Z;
    private Button actualiser, remise_a_zero;
    String url, ip;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deplacements);

        this.actualiser = (Button) findViewById(R.id.actualiser);
        this.remise_a_zero = (Button) findViewById(R.id.remise_a_zero);

        this.pos_X = (TextView) findViewById(R.id.pos_X);
        this.pos_Y = (TextView) findViewById(R.id.pos_Y);
        this.pos_Z = (TextView) findViewById(R.id.pos_Z);

        this.y_up1 = (ImageView) findViewById(R.id.y_up1);
        this.y_down1 = (ImageView) findViewById(R.id.y_down1);
        this.x_left1 = (ImageView) findViewById(R.id.x_left1);
        this.x_right1 = (ImageView) findViewById(R.id.x_right1);
        this.z_up1 = (ImageView) findViewById(R.id.z_up1);
        this.z_down1 = (ImageView) findViewById(R.id.z_down1);

        this.backArrow2 = (ImageView) findViewById(R.id.backArrow2);

        ip = readData();
        ip = ip.replaceAll("\\s",""); //Permet de supprimer l'espace crée à la fin du fichier texte à la lecture de ce dernier

        backArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuuu = new Intent(getApplicationContext(), Menu.class);
                startActivity(menuuu);
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        /*  =================================================================================
            ==========================  Déplacements de l'axe X  ============================
            ================================================================================= */

        x_right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeX/deplacePositionAxeX/up";

                StringRequest xUpRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "X : Up", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(xUpRequest);

                Animation animFadeInXUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                x_right1.startAnimation(animFadeInXUp);
            }

        });

        x_left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeX/deplacePositionAxeX/down";

                StringRequest xDownRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "X : Down", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(xDownRequest);

                Animation animFadeInXDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                x_left1.startAnimation(animFadeInXDown);
            }
        });

        /*  =================================================================================
            ==========================  Déplacements de l'axe Y  ============================
            ================================================================================= */

        y_down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeY/deplacePositionAxeY/down";

                StringRequest yDownRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Y : Down", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(yDownRequest);

                Animation animFadeInYLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                y_down1.startAnimation(animFadeInYLeft);
            }
        });

        y_up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeY/deplacePositionAxeY/up";

                StringRequest yUpRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Y : Up", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(yUpRequest);

                Animation animFadeInYRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                y_up1.startAnimation(animFadeInYRight);
            }
        });

        /*  =================================================================================
            ==========================  Déplacements de l'axe Z  ============================
            ================================================================================= */

        z_up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeZ/deplacePositionAxeZ/up";

                StringRequest zUpRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Z : Up", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(zUpRequest);

                Animation animFadeInZUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                z_up1.startAnimation(animFadeInZUp);
            }
        });

        z_down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeZ/deplacePositionAxeZ/down";

                StringRequest zDownRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Z : Down", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                queue.add(zDownRequest);

                Animation animFadeInZDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                z_down1.startAnimation(animFadeInZDown);
            }
        });


        actualiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/axeX/getPositionAxeX";
                StringRequest xRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pos_X.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "Error : " + error.toString());
                        pos_X.setText("Error");
                    }
                });
                queue.add(xRequest);


                url = "http://"+ ip +":8080/monitor/axeY/getPositionAxeY";
                StringRequest yRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pos_Y.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "Error : " + error.toString());
                        pos_Y.setText("Error");
                    }
                });
                queue.add(yRequest);


                url = "http://"+ ip +":8080/monitor/axeZ/getPositionAxeZ";
                StringRequest zRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pos_Z.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "Error : " + error.toString());
                        pos_Z.setText("Error");
                    }
                });
                queue.add(zRequest);
            }
        });

        remise_a_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                url = "http://"+ ip +":8080/monitor/RAZ";

                StringRequest razRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Remise à zéro", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(razRequest);
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

    protected void onStop() {
        super.onStop();
    }
}