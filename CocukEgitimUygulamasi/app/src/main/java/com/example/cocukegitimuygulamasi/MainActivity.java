package com.example.cocukegitimuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ImageView image5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public  void biregit(View view){
        Intent intent = new Intent(MainActivity.this,Soru1.class);
        startActivity(intent);
    }

    public  void eslestirmeyegit(View view){
        Intent intent = new Intent(MainActivity.this,Kelime1.class);
        startActivity(intent);
    }

    public  void rengit(View view){
        Intent intent = new Intent(MainActivity.this,Renk1.class);
        startActivity(intent);
    }

    public  void bayrakgit(View view){

        image5 = findViewById(R.id.image5);

        veritabaniKopyala();

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Bayrak2.class));
            }
        });
    }

    public void veritabaniKopyala(){
        BayrakVTC copyHelper = new BayrakVTC(this);

        try {
            copyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        copyHelper.openDataBase();

    }

    public  void hafgit(View view){
        Intent intent = new Intent(MainActivity.this,Hafiza1.class);
        startActivity(intent);
    }

    public  void dygit(View view){
        Intent intent = new Intent(MainActivity.this,DogruYanlis1.class);
        startActivity(intent);
    }
}
