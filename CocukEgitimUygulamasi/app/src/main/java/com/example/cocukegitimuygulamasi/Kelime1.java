package com.example.cocukegitimuygulamasi;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Kelime1 extends AppCompatActivity {

    private Kelime2 fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime1);

        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);

        if (size.x>size.y)
            getSupportActionBar().hide();



        FragmentManager fm= getSupportFragmentManager();
        fragment = (Kelime2) fm.findFragmentByTag("etiket");

        if (fragment==null){

            fragment=new Kelime2();
            fm.beginTransaction().add(R.id.container,fragment,"etiket").commit();
        }


    }
    public  void bit(View view){
        Intent intent = new Intent(Kelime1.this,MainActivity.class);
        startActivity(intent);
    }
}


