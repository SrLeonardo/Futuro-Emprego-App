package com.example.futuroemprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaEf extends AppCompatActivity {

    private Button buttonPot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ef);

        buttonPot = findViewById(R.id.buttonPot);

        buttonPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaAulaPt.class);
                startActivity( intent );
            }
        });

    }
}
