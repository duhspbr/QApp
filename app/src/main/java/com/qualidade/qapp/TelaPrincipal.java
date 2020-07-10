package com.qualidade.qapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    Processar processar;
    LoginClass loginClass;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        setTitle("Menu Principal");

        processar = new Processar();
        TextView textVData = (TextView) findViewById(R.id.textVData);
        textVData.setText(processar.getData().toString());

        loginClass = new LoginClass();
        TextView textVUser = (TextView) findViewById(R.id.textVUser);
        textVUser.setText(loginClass.getUsuario());
    }

    public void chamartelaDod(View view) {
        Intent intent = new Intent(this, FormDOD.class);
        startActivity(intent);
    }

    public void chamartelaReportarNok(View view) {
        Intent intent = new Intent(this, TelaReportarNok.class);
        startActivity(intent);
    }

    public void chamartelaCabecalho(View view) {
        Intent intent = new Intent(this, TelaCabecalho.class);
        startActivity(intent);
    }

    public void chamartelatelaReceb(View view) {
        Intent intent = new Intent(this, TelaReceb.class);
        startActivity(intent);
    }
}