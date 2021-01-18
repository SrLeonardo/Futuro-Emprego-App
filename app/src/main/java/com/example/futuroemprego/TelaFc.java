package com.example.futuroemprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaFc extends AppCompatActivity {

    private Button buttonNie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fc);

        buttonNie = findViewById(R.id.buttonie);

        buttonNie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), TelaNietzsche.class);
               startActivity( intent );
            }
        });


    }


}
