package com.qualidade.qapp.telainicial;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qualidade.qapp.R;
import com.qualidade.qapp.dashboard.ActivityDashBoard;
import com.qualidade.qapp.login.MainActivity;
import com.qualidade.qapp.psc_bancario.ActivityPSCRecord;
import com.qualidade.qapp.psc_bancario.ActivityPscResult;
import com.qualidade.qapp.psc_bancario.ListaItens;
import com.qualidade.qapp.psc_bancario.NotePSC;
import com.qualidade.qapp.rejeitos_dod.ActivityRejeitosDod;

import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

public class TelaPrincipal extends AppCompatActivity {

    public static final String EXTRA_USER =
            "com.qualidade.qapp.TelaPrincipal.EXTRA_USER";

    private String auditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        setTitle("Menu Principal");

        Button btnPSC = findViewById(R.id.btnPSC);

        Intent intent = getIntent();
        auditor = intent.getStringExtra(MainActivity.EXTRA_USER);

        btnPSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaCabecalho();
            }
        });
    }

    public void callTelaDod(View view) {
        Intent intent = new Intent(this, ActivityRejeitosDod.class);
        intent.putExtra(EXTRA_USER, auditor);
        startActivity(intent);
    }

    public void callTelaCabecalho() {
        Intent intent = new Intent(this, ActivityPscResult.class);
        intent.putExtra(EXTRA_USER, auditor);
        startActivity(intent);
    }

    public void callTelaDash(View view) {
        Intent intent = new Intent(this, ActivityDashBoard.class);
        startActivity(intent);
    }
}