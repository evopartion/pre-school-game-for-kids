package com.example.cocukegitimuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Soru3 extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button tekrarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru3);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        tekrarbtn = (Button) findViewById(R.id.tekrarbtn);


        StringBuffer sb = new StringBuffer();

        sb.append("Doğru Sayısı:   " + Soru2.dogru + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Yanlış Sayısı: " + Soru2.yanlis + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Sonuç: " + Soru2.sonuc + "\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Soru2.dogru=0;
        Soru2.yanlis=0;

        tekrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soru3.this,Soru1.class);
                startActivity(intent);
            }
        });
    }

}
