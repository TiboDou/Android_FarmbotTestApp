package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "tonIPestIci.txt";
    private Button start;
    private EditText adresseIP;
    String addr;

    //Pour l'utilisation de Patterns, voir la page https://developer.android.com/reference/java/util/regex/Pattern
    public static final String ADDR_IP_PATTERN = "^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                                                 "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                                                 "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                                                 "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.start = (Button) findViewById(R.id.start); //Permet de récupérer la vue par rapport à un identifiant associé à cette dernière
        adresseIP = (EditText) findViewById(R.id.adresseIP);

        addr = readData();
        addr = addr.replaceAll("\\s","");
        adresseIP.setText(addr);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addr = adresseIP.getText().toString();
                Matcher matcher = Pattern.compile(ADDR_IP_PATTERN).matcher(addr);

                if (matcher.find()) {
                    Intent menuActivity = new Intent(MainActivity.this, Menu.class);

                    writeData();

                    startActivity(menuActivity);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Adresse IP erronée", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void writeData() {
        FileOutputStream fos = null;

        try {

            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            fos.write(addr.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readData() {

        FileInputStream fis = null;
        String ip = "";

        try {
            fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            ip = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }
}