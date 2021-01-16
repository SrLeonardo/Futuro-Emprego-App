package com.example.futuroemprego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {

    private TextView textCadastro;
    private EditText loginEmail, loginSenha;
    private Button buttonLogar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        textCadastro = findViewById(R.id.textCadastro);
        loginEmail = findViewById(R.id.loginEmail);
        loginSenha = findViewById(R.id.loginSenha);
        buttonLogar = findViewById(R.id.buttonLogar);


        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = loginEmail.getText().toString();
                String textoSenha = loginSenha.getText().toString();

                if (!textoEmail.isEmpty()) {
                    if ( !textoSenha.isEmpty()){




                    }else{
                        Toast.makeText( TelaLogin.this,
                                "Preencha a Senha!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(TelaLogin.this,
                            "Preencha o Email!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });



        textCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);

                startActivity(intent);
            }
        });

    }
}
