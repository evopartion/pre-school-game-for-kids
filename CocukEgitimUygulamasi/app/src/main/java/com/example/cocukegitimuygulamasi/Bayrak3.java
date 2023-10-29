package com.example.cocukegitimuygulamasi;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bayrak3 extends AppCompatActivity {
    private TextView textViewSonuc,textViewYuzdeSonuc;
    private Button buttonTekrar,buttonTekrar2;
    private int dogruSayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrak3);

        textViewSonuc = findViewById(R.id.textViewSonuc);
        textViewYuzdeSonuc = findViewById(R.id.textViewYuzdeSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);
        buttonTekrar2 = findViewById(R.id.buttonTekrar2);

        dogruSayac = getIntent().getIntExtra("dogruSayac",0);

        textViewSonuc.setText(dogruSayac+" DOĞRU "+(5-dogruSayac)+" YANLIŞ");
        textViewYuzdeSonuc.setText("%"+(dogruSayac*20)+" Başarı");

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Bayrak3.this,Bayrak2.class));
                finish();
            }
        });
        buttonTekrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Bayrak3.this,MainActivity.class));
                finish();
            }
        });
    }
}
