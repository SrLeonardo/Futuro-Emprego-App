package com.example.futuroemprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaHome extends AppCompatActivity {

    private Button buttonPt;
    private Button buttonFc;
    private Button buttonEf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home2);



      buttonPt = findViewById(R.id.buttonPt);
      buttonFc = findViewById(R.id.buttonFc);
      buttonEf = findViewById(R.id.buttonEf);

      buttonEf.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent = new Intent(getApplicationContext(), TelaEf.class);
              startActivity( intent );
          }
      });


      buttonFc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent = new Intent(getApplicationContext(), TelaFc.class);
              startActivity( intent );
          }
      });


        buttonPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TelaAulaPt.class);
                startActivity( intent );
            }
        });

    }
}
