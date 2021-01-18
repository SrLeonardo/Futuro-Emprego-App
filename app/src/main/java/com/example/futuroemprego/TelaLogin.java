package com.example.futuroemprego;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.futuroemprego.config.ConfiguracaoFirebase;
import com.example.futuroemprego.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class TelaLogin extends AppCompatActivity {

    private TextView textCadastro;
    private EditText loginEmail, loginSenha;
    private Button buttonLogar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;


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
            public void onClick(View v) {
                String textoEmail = loginEmail.getText().toString();
                String textoSenha = loginSenha.getText().toString();

                if (!textoEmail.isEmpty()) {
                    if ( !textoSenha.isEmpty()){

                        usuario = new Usuario();
                        usuario.setEmail( textoEmail );
                        usuario.setSenha( textoSenha );
                        validarLogin();

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

    public void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if( task.isSuccessful()){

                  abrirTelaHome();

                }else{
                    String excecao = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e Senha não Correspondem a um Usuário Cadastrado";
                    }catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuário não está Cadastrado!";
                    }catch (Exception e){
                        excecao = "Erro ao Logar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(TelaLogin.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void abrirTelaHome(){
        finish();
        startActivity(new Intent(this, TelaHome.class));

    }
}
