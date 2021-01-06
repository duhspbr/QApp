package com.qualidade.qapp.telainicial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qualidade.qapp.R;
import com.qualidade.qapp.dashboard.ActivityDashBoard;
import com.qualidade.qapp.psc_bancario.ActivityPscResult;
import com.qualidade.qapp.rejeitos_dod.ActivityRejeitosDod;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        setTitle("Menu Principal");

        Button btnPSC = findViewById(R.id.btnPSC);

        btnPSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaCabecalho();
            }
        });
    }

    public void callTelaDod(View view) {
        Intent intent = new Intent(this, ActivityRejeitosDod.class);
        startActivity(intent);
    }

    public void callTelaCabecalho() {
        Intent intent = new Intent(this, ActivityPscResult.class);
        startActivity(intent);
    }

    public void callTelaDash(View view) {
        Intent intent = new Intent(this, ActivityDashBoard.class);
        startActivity(intent);
    }
}