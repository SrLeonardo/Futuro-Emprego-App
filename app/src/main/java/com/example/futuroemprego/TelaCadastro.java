package com.example.futuroemprego;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.futuroemprego.config.ConfiguracaoFirebase;
import com.example.futuroemprego.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaCadastro extends AppCompatActivity {


    private FirebaseAuth autenticacao;

    private EditText nome,sobrenome,senha,cSenha,email;
    private Button buttonCadastro;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

    nome = findViewById(R.id.nome);
    sobrenome = findViewById(R.id.sobrenome);
    email = findViewById(R.id.email);
    senha = findViewById(R.id.senha);
    cSenha = findViewById(R.id.cSenha);
    buttonCadastro = findViewById(R.id.buttonCadastro);

    buttonCadastro.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){

        String textoNome = nome.getText().toString();
        String textoSobrenome = sobrenome.getText().toString();
        String textoEmail = email.getText().toString();
        String textoSenha = senha.getText().toString();
        String textoCsenha = cSenha.getText().toString();

        if ( !textoNome.isEmpty()){
            if ( !textoSobrenome.isEmpty()){
                if ( !textoSenha.isEmpty()){
                    if ( !textoCsenha.isEmpty()){
                        if ( !textoEmail.isEmpty()){
                            usuario = new Usuario();
                            usuario.setNome( textoNome );
                            usuario.setSobrenome( textoSobrenome );
                            usuario.setSenha( textoSenha );
                            usuario.setcSenha( textoCsenha );
                            usuario.setEmail( textoEmail );
                            cadastrarUsuario();


                        }else {
                            Toast.makeText(TelaCadastro.this,
                                    "Preencha o Email!",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }else{
                            Toast.makeText( TelaCadastro.this,
                                    "Preencha o Confirmar Senha!",
                                    Toast.LENGTH_SHORT).show();
                        }


                }else{
                    Toast.makeText( TelaCadastro.this,
                            "Preencha a Senha!",
                            Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText( TelaCadastro.this,
                        "Preencha o Sobrenome!",
                        Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText( TelaCadastro.this,
                    "Preencha o Nome!",
                    Toast.LENGTH_SHORT).show();
        }

        }
    });
    }


    public void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful()){
                    Toast.makeText( TelaCadastro.this,
                            "Sucesso ao Cadastrar Usuário!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText( TelaCadastro.this,
                            "Erro ao Cadastrar Usuário!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}