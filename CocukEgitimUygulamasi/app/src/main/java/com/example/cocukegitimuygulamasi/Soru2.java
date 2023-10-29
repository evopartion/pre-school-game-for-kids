package com.example.cocukegitimuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Soru2 extends AppCompatActivity {
    TextView tv;
    Button cevapla, kapat;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String sorular[] = {
            "Aşağıdakilerden hangisi bir yön belirtmez ?",
            "Atatürk hangi yılda doğmuştur?",
            "(3+5)*2 sorusunun cevabı nedir?",
            "Görmemizi sağlayan duyu organımız nedir?",
            "Hangi uzunluk ölçüsü daha  büyüktür?",
            "Karenin çevresi nasıl bulunur?",
            "Güneşe en yakın olan gezegen hangisidir?",
            "2010 yılında yaş ortalaması 10 olan 3 arkadaşın 2020 yılındaki yaş ortalaması kaçtır?",
            "Maddenin hallerinden hangisi bulunduğu kapın şeklini alır?",
            "Türkiyenin Başkenti neresidir?"
    };
    String dyanitlar[] = {"Doğubatı","1881","16","Göz","Kilometre","4*Kenar","Merkür","20","Sıvı","Ankara"};
    String yanitlar[] = {
            "Kuzeydoğu","Güney","Doğubatı","Kuzey",
            "1880","1881","1882","1883",
            "13","16","11","45",
            "Kulak","Burun","Boğaz","Göz",
            "Metre","Kilometre","Santimetre","Milimetre",
            "4*Kenar","2*pi*yarıçap","2(kısa kenar+uzun kenar)","kısa kenar * uzun kenar",
            "Merkür","Dünya","Satürn","Neptün",
            "10","20","25","30",
            "Katı","Sıvı","Gaz","Plazma",
            "Ankara","İstanbul","İzmir","Trabzon"
    };
    int sayac=0;
    public static int sonuc=0,dogru=0,yanlis=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru2);

        final TextView skor = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.k_adi);
        Intent intent = getIntent();

        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Merhaba Kullanıcı");
        else
            textView.setText("Merhaba " + name);

        cevapla=(Button)findViewById(R.id.button3);
        kapat=(Button)findViewById(R.id.button4);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.yanitgrup);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);


        tv.setText(sorular[sayac]);
        rb1.setText(yanitlar[0]);
        rb2.setText(yanitlar[1]);
        rb3.setText(yanitlar[2]);
        rb4.setText(yanitlar[3]);

        cevapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Lütfen bir seçim yapın!", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton rb = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = rb.getText().toString();

                if(ansText.equals(dyanitlar[sayac])) {
                    dogru++;
                    Toast.makeText(getApplicationContext(), "Doğru", Toast.LENGTH_SHORT).show();
                }
                else {
                    yanlis++;
                    Toast.makeText(getApplicationContext(), "Yanlış", Toast.LENGTH_SHORT).show();
                }

                sayac++;

                if (skor != null)
                    skor.setText(""+dogru);

                if(sayac<sorular.length)
                {
                    tv.setText(sorular[sayac]);
                    rb1.setText(yanitlar[sayac*4]);
                    rb2.setText(yanitlar[sayac*4 +1]);
                    rb3.setText(yanitlar[sayac*4 +2]);
                    rb4.setText(yanitlar[sayac*4 +3]);
                }
                else
                {

                    sonuc=10*(dogru-yanlis);
                    if (sonuc<0){
                        sonuc=0;
                    }
                    else
                    {
                        sonuc=sonuc;
                    }

                    Intent intent = new Intent(Soru2.this,Soru3.class);
                    startActivity(intent);
                }

                radio_g.clearCheck();
            }
        });

        kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soru2.this,Soru3.class);
                startActivity(intent);
            }
        });
    }

}

