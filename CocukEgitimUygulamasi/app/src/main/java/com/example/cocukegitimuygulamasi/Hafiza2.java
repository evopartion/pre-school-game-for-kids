package com.example.cocukegitimuygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hafiza2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafiza2);
    }
    public void hafto(View view){
        Intent intent = new Intent(Hafiza2.this,Hafiza1.class);
        startActivity(intent);
    }
    public void hafcik(View view){
        Intent intent = new Intent(Hafiza2.this,MainActivity.class);
        startActivity(intent);
    }
}
