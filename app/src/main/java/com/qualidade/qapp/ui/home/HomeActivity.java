package com.qualidade.qapp.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qualidade.qapp.R;
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

        Intent intent = getIntent();
        auditor = intent.getStringExtra(LoginMainActivity.EXTRA_USER);

        btnPSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelaCabecalho();
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

    public void callTelaDash(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}