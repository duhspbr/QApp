package com.qualidade.qapp.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qualidade.qapp.R;
import com.qualidade.qapp.databinding.ActivityLoginBinding;
import com.qualidade.qapp.databinding.ActivityMainscreenBinding;
import com.qualidade.qapp.ui.cqm.CqmListActivity;
import com.qualidade.qapp.ui.dashboard.DashboardActivity;
import com.qualidade.qapp.ui.psc.PscListActivity;
import com.qualidade.qapp.ui.dod.DodListActivity;

public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_USER =
            "com.qualidade.qapp.HomeActivity.EXTRA_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainscreenBinding binding = ActivityMainscreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnPSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PscListActivity.class));
            }
        });

        binding.btnCQM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CqmListActivity.class));
            }
        });

        binding.btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            }
        });

        binding.btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnDOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DodListActivity.class));
            }
        });
    }
}