package com.qualidade.qapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qualidade.qapp.R;
import com.qualidade.qapp.telainicial.TelaPrincipal;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textvNew = findViewById(R.id.textVNew);

        textvNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Login_ListaUsers.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {

        intent = new Intent(this, TelaPrincipal.class);

        EditText editTextNome = findViewById(R.id.editNome);
        EditText editTextSenha = findViewById(R.id.editPass);

        if (editTextNome.getText().equals("adm") && editTextSenha.getText().equals("123")) {
            Toast.makeText(getApplicationContext(), "Bem vindo, ", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Falha de acesso! Tente novamente.", Toast.LENGTH_LONG).show();
        }
    }
}