package com.example.cocukegitimuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Soru1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru1);

        Button basla = (Button) findViewById(R.id.button);
        final EditText nametext = (EditText) findViewById(R.id.editName);

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                Intent intent = new Intent(Soru1.this, Soru2.class);
                intent.putExtra("myname", name);
                startActivity(intent);
            }
        });

    }

    public void anadon(View view){
        Intent intent = new Intent(Soru1.this,MainActivity.class);
        startActivity(intent);
    }
}
