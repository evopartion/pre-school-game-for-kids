package com.example.cocukegitimuygulamasi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Renk1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk1);

        Button click1=(Button)findViewById(R.id.button1);
        Button click2=(Button)findViewById(R.id.button2);
        Button click3=(Button)findViewById(R.id.button3);
        Button click4=(Button)findViewById(R.id.button4);
        Button click5=(Button)findViewById(R.id.button5);
        Button click6=(Button)findViewById(R.id.button6);
        Button click7=(Button)findViewById(R.id.button7);
        Button click8=(Button)findViewById(R.id.button8);



        final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(), R.raw.red);
        final MediaPlayer mp2=MediaPlayer.create(getApplicationContext(), R.raw.orange);
        final MediaPlayer mp3=MediaPlayer.create(getApplicationContext(), R.raw.yellow);
        final MediaPlayer mp4=MediaPlayer.create(getApplicationContext(), R.raw.green);
        final MediaPlayer mp5=MediaPlayer.create(getApplicationContext(), R.raw.blue);
        final MediaPlayer mp6=MediaPlayer.create(getApplicationContext(), R.raw.purple);
        final MediaPlayer mp7=MediaPlayer.create(getApplicationContext(), R.raw.pink);
        final MediaPlayer mp8=MediaPlayer.create(getApplicationContext(), R.raw.black);


        View.OnClickListener tikla = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.button1:
                        mp1.start();
                        break;
                    case R.id.button2:
                        mp2.start();
                        break;
                    case R.id.button3:
                        mp3.start();
                        break;
                    case R.id.button4:
                        mp4.start();
                        break;
                    case R.id.button5:
                        mp5.start();
                        break;
                    case R.id.button6:
                        mp6.start();
                        break;

                    case R.id.button7:
                        mp7.start();
                        break;
                    case R.id.button8:
                        mp8.start();
                        break;

                }
            }
        };



        click1.setOnClickListener(tikla);
        click2.setOnClickListener(tikla);
        click3.setOnClickListener(tikla);
        click4.setOnClickListener(tikla);
        click5.setOnClickListener(tikla);
        click6.setOnClickListener(tikla);
        click7.setOnClickListener(tikla);
        click8.setOnClickListener(tikla);
    }
}


