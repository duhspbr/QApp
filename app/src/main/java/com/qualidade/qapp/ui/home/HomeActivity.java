package com.qualidade.qapp.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Cqm;
import com.qualidade.qapp.ui.cqm.CqmListActivity;
import com.qualidade.qapp.ui.dashboard.DashboardActivity;
import com.qualidade.qapp.ui.login.LoginMainActivity;
import com.qualidade.qapp.ui.psc.PscListActivity;
import com.qualidade.qapp.ui.dod.DodListActivity;

public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_USER =
            "com.qualidade.qapp.HomeActivity.EXTRA_USER";

    private String auditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        setTitle("Menu Principal");

        Button btnPSC = findViewById(R.id.btnPSC);
        Button btnCqm = findViewById(R.id.btnCQM);
        Button btnDashboard = findViewById(R.id.btnDashboard);
        Button btnSair = findViewById(R.id.btn_sair);

        Intent intent = getIntent();
        auditor = intent.getStringExtra(LoginMainActivity.EXTRA_USER);

        btnPSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaCabecalho();
            }
        });

        btnCqm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaCqm();
            }
        });

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaDash();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSair();
            }
        });
    }

    public void callTelaDod(View view) {
        Intent intent = new Intent(this, DodListActivity.class);
        intent.putExtra(EXTRA_USER, auditor);
        startActivity(intent);
    }

    public void callTelaCabecalho() {
        Intent intent = new Intent(this, PscListActivity.class);
        intent.putExtra(EXTRA_USER, auditor);
        startActivity(intent);
    }

    public void callTelaDash() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void callTelaCqm() {
        Intent intent = new Intent(this, CqmListActivity.class);
        startActivity(intent);
    }

    public void callSair() {
        finish();
    }
}