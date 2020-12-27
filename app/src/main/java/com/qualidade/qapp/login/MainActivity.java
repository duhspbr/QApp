package com.qualidade.qapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.qualidade.qapp.R;
import com.qualidade.qapp.TelaPrincipal;
import com.qualidade.qapp.login.LoginClass;

public class MainActivity extends AppCompatActivity {

    LoginClass loginClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick(View view) {
        loginClass = new LoginClass();
        Intent intent = new Intent(this, TelaPrincipal.class);

        EditText editTextNome = findViewById(R.id.editNome);
        EditText editTextSenha = findViewById(R.id.editPass);

        loginClass.setUsuario(editTextNome.getText().toString());
        loginClass.setSenha(editTextSenha.getText().toString());

        if (loginClass.checkLogin()) {
            Toast.makeText(getApplicationContext(), "Bem vindo, " + loginClass.getUsuario().toString(), Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Falha de acesso! Tente novamente.", Toast.LENGTH_LONG).show();
        }
    }
}