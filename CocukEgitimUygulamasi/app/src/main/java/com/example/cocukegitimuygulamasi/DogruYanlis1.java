package com.example.cocukegitimuygulamasi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;

public class DogruYanlis1 extends AppCompatActivity {



    TextView text1;
    Button buttond,buttony;

    DogruYanlis2 sorularsinifi;
    int sorusayisi;


    ArrayList<DogruYanlis3> sorulistesi;
    int konumun=0;
    boolean kontrol=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogru_yanlis1);

        text1=(TextView) findViewById(R.id.text1);

        buttond=(Button)findViewById(R.id.buttond);
        buttony=(Button)findViewById(R.id.buttony);


        sorularsinifi=new DogruYanlis2();
        sorusayisi= sorularsinifi.sorular.length;
        sorulistesi=new ArrayList<>();


        for (int i=0; i<sorusayisi;i++){

            sorulistesi.add(new DogruYanlis3(sorularsinifi.getQuestions(i),sorularsinifi.getAnswers(i)));
        }


        Collections.shuffle(sorulistesi);
        setSoru(konumun);


        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSoru(konumun)){

                    konumun++;
                    if (konumun<sorusayisi){
                        setSoru(konumun);

                    }
                    else{
                        kontrol=true;
                        bitir();

                    }


                }
                else {
                    bitir();

                }

            }
        });

        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkSoru(konumun)){

                    konumun++;
                    if (konumun<sorusayisi){
                        setSoru(konumun);

                    }
                    else{
                        kontrol=true;
                        bitir();

                    }


                }
                else {
                    bitir();

                }

            }
        });
    }

    private  void  setSoru(int number){

        text1.setText((sorulistesi.get(number).getQuestion()));
    }

    private  boolean checkSoru(int number){

        String answer =sorulistesi.get(number).getAnswer();
        return  answer.equals("true");
    }

    private  void  bitir(){

        if(kontrol){

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Tebrikler bütün soruları doğru cevapladın tekrar oynamak ister misin?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(DogruYanlis1.this,DogruYanlis1.class);
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(DogruYanlis1.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }


        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Maalesef yanlış cevap tekrar oynamak ister misin?");
            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(DogruYanlis1.this,DogruYanlis1.class);
                    startActivity(intent);

                }
            });
            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(DogruYanlis1.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            alert.show();

        }
    }
}

