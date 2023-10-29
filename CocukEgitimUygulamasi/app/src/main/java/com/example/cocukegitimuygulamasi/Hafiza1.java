package com.example.cocukegitimuygulamasi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Hafiza1 extends AppCompatActivity {

    ImageView imageView=null;

    private  int bulunan=0;
    final  int[] drawable= new int[] {R.drawable.s1,R.drawable.s2,R.drawable.s3,
            R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8};

    int[] indis = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int s_indis=-1;
    int kalan=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafiza1);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        Hafiza3 imageAdapter = new Hafiza3(this);
        gridView.setAdapter(imageAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (s_indis<0){
                    s_indis = position;

                    imageView=(ImageView)view;
                    ((ImageView)view).setImageResource(drawable[indis[position]]);
                }

                else
                {
                    if (s_indis==position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.arka);

                    }
                    else if(indis[s_indis]!=indis[position])
                    {
                        imageView.setImageResource(R.drawable.arka);
                        Toast.makeText(getApplicationContext(),"EŞLEŞTİRME BAŞARISIZ",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        ((ImageView)view).setImageResource(drawable[indis[position]]);
                        bulunan++;

                        if (bulunan!=0)
                        {
                            Toast.makeText(getApplicationContext(),"EŞLEŞTİRME BAŞARILI",Toast.LENGTH_SHORT).show();
                            kalan--;

                        }
                        if(kalan==0)
                        {
                            Intent intent=new Intent(Hafiza1.this,Hafiza2.class);
                            startActivity(intent);

                        }
                    }

                    s_indis=-1;

                }
            }
        });
    }
}


