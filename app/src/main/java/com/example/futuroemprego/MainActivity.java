package com.example.futuroemprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.futuroemprego.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button buttonComecar;
    private FirebaseAuth autenti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonComecar = findViewById(R.id.buttonComecar);

        buttonComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TelaLogin.class);

                startActivity(intent);


            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void verificarUsuarioLogado(){
        autenti = ConfiguracaoFirebase.getFirebaseautenticacao();

        if(autenti.getCurrentUser() != null){
            finish();
            abrirTelaHome();
        }

    }
    public void abrirTelaHome(){
        startActivity(new Intent(this, TelaHome.class));

    }

}
