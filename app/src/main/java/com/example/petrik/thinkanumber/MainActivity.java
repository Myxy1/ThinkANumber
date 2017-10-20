package com.example.petrik.thinkanumber;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageV_elet1, imageV_elet2, imageV_elet3, imageV_elet4, imageV_elet5;
    private Button btn_novel, btn_csokkent, btn_kuldes;
    private TextView textV_szam;
    private int szam = 0; //szám, amire a felhasználó tippel
    private int kitalalt_szam = 0; //kitalált szám, amit a gép talál ki
    private int elet = 5; //felhasználó élete

    private AlertDialog.Builder alert_veszit, alert_nyert;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageV_elet1 = (ImageView) findViewById(R.id.imageView_elet1);
        imageV_elet2 = (ImageView) findViewById(R.id.imageView_elet2);
        imageV_elet3 = (ImageView) findViewById(R.id.imageView_elet3);
        imageV_elet4 = (ImageView) findViewById(R.id.imageView_elet4);
        imageV_elet5 = (ImageView) findViewById(R.id.imageView_elet5);

        btn_novel = (Button) findViewById(R.id.btn_plus);
        btn_csokkent = (Button) findViewById(R.id.btn_negative);
        btn_kuldes = (Button) findViewById(R.id.btn_submit);

        textV_szam = (TextView) findViewById(R.id.textView_szam);

        alert_veszit = new AlertDialog.Builder(MainActivity.this);
        alert_veszit.setTitle("Vesztettél!")         //Cím adás
                .setMessage("Újra akarod kezdeni a játékot?")       //Kérdés amit felteszünk.
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new_game();
                    }
                })
                .setCancelable(false)       //Ezzel azt csináljuk, hogy nem lehet kikattintani a dialog boxból.
                .create();      //Létrehozzuk

        alert_nyert = new AlertDialog.Builder(MainActivity.this);
        alert_nyert.setTitle("Gratulálok nyertél!")         //Cím adás
                .setMessage("Újra akarod kezdeni a játékot?")       //Kérdés amit felteszünk.
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new_game();
                    }
                })
                .setCancelable(false)   //Ezzel azt csináljuk, hogy nem lehet kikattintani a dialog boxból.
                .create();           //Létrehozzuk


        kitalalt_szam = r.nextInt(10)+1;

        btn_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (szam<10) {
                   szam++;
               }
                textV_szam.setText("" + szam);
            }
        });

        btn_csokkent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam>0) {
                    szam--;
                }
                textV_szam.setText(""+szam);
            }
        });

        btn_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam == kitalalt_szam){
                        alert_nyert.show();
                        Toast.makeText(MainActivity.this,"Megcsináltad!",Toast.LENGTH_SHORT).show();
                }else if (szam > kitalalt_szam){
                    elet--;
                    switch (elet){
                        case 4:
                            imageV_elet1.setBackgroundResource(0);
                            imageV_elet1.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Lentebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            imageV_elet2.setBackgroundResource(0);
                            imageV_elet2.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Lentebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            imageV_elet3.setBackgroundResource(0);
                            imageV_elet3.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Lentebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            imageV_elet4.setBackgroundResource(0);
                            imageV_elet4.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Lentebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 0:
                            imageV_elet5.setBackgroundResource(0);
                            imageV_elet5.setImageResource(R.drawable.heart1);
                            alert_veszit.show();
                            break;
                    }

                }else if (szam < kitalalt_szam){
                    elet--;
                    switch (elet) {
                        case 4:
                            imageV_elet1.setBackgroundResource(0);
                            imageV_elet1.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Feljebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            imageV_elet2.setBackgroundResource(0);
                            imageV_elet2.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Feljebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            imageV_elet3.setBackgroundResource(0);
                            imageV_elet3.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Feljebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            imageV_elet4.setBackgroundResource(0);
                            imageV_elet4.setBackgroundResource(R.drawable.heart1);
                            Toast.makeText(MainActivity.this,"Feljebb!",Toast.LENGTH_SHORT).show();
                            break;
                        case 0:
                            imageV_elet5.setBackgroundResource(0);
                            imageV_elet5.setImageResource(R.drawable.heart1);
                            alert_veszit.show();
                            break;
                    }
                }
            }
        });

    }

    public void new_game(){

        kitalalt_szam = r.nextInt(10)+1;
        textV_szam.setText("0");
        szam = 0;
        elet = 5;
        imageV_elet1.setBackgroundResource(0);
        imageV_elet2.setBackgroundResource(0);
        imageV_elet3.setBackgroundResource(0);
        imageV_elet4.setBackgroundResource(0);
        imageV_elet5.setBackgroundResource(0);
        imageV_elet1.setBackgroundResource(R.drawable.heart2);
        imageV_elet2.setBackgroundResource(R.drawable.heart2);
        imageV_elet3.setBackgroundResource(R.drawable.heart2);
        imageV_elet4.setBackgroundResource(R.drawable.heart2);
        imageV_elet5.setBackgroundResource(R.drawable.heart2);
    }
}
