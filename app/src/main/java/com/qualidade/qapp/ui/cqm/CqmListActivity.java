package com.qualidade.qapp.ui.cqm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Cqm;
import com.qualidade.qapp.ui.home.HomeActivity;

import java.util.Collections;
import java.util.List;

public class CqmListActivity extends AppCompatActivity {

    public static final int ADD_NOTE_REQUEST = 1;
    private CqmViewModel cqmViewModel;
    private String auditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cqm_list);

        Intent intent = getIntent();
        auditor = intent.getStringExtra(HomeActivity.EXTRA_USER);

        FloatingActionButton btnAdd = findViewById(R.id.btn_save);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CqmListActivity.this, CqmRecordActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcv_cqm_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final CqmAdapter cqmAdapter = new CqmAdapter();
        recyclerView.setAdapter(cqmAdapter);

        cqmViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CqmViewModel.class);
        cqmViewModel.getAllCqm().observe(this, new Observer<List<Cqm>>() {
            @Override
            public void onChanged(List<Cqm> cqms) { cqmAdapter.setCqms(cqms); }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String maquina = data.getStringExtra(CqmRecordActivity.EXTRA_MAQUINA);
            String date = data.getStringExtra(CqmRecordActivity.EXTRA_DATA);
            String hora = data.getStringExtra(CqmRecordActivity.EXTRA_HORA);
            String rd1_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD1_1);
            String rd1_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD1_2);
            String rd2_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD2_1);
            String rd2_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD2_2);
            String rd3_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD3_1);
            String rd3_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD3_2);
            String rd4_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD4_1);
            String rd4_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD4_2);
            String rd5_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD5_1);
            String rd5_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD5_2);
            String rd6_1 = data.getStringExtra(CqmRecordActivity.EXTRA_RD6_1);
            String rd6_2 = data.getStringExtra(CqmRecordActivity.EXTRA_RD6_2);
            String cham1_1 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM1_1);
            String cham1_2 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM1_2);
            String cham2_1 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM2_1);
            String cham2_2 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM2_2);
            String cham3_1 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM3_1);
            String cham3_2 = data.getStringExtra(CqmRecordActivity.EXTRA_CHAM3_2);
            String obs1 = data.getStringExtra(CqmRecordActivity.EXTRA_OBS1);
            String obs2 = data.getStringExtra(CqmRecordActivity.EXTRA_OBS2);
            String obs3 = data.getStringExtra(CqmRecordActivity.EXTRA_OBS3);
            String area1_p1 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA1_P1);
            String area1_p2 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA1_P2);
            String area1_p3 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA1_P3);
            String area2_s4_p1 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S4_P1);
            String area2_s4_p2 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S4_P2);
            String area2_s4_p3 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S4_P3);
            String area2_s3_p1 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S3_P1);
            String area2_s3_p2 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S3_P2);
            String area2_s3_p3 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S3_P3);
            String area2_s2_p1 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S2_P1);
            String area2_s2_p2 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S2_P2);
            String area2_s2_p3 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S2_P3);
            String area2_s1_p1 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S1_P1);
            String area2_s1_p2 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S1_P2);
            String area2_s1_p3 = data.getStringExtra(CqmRecordActivity.EXTRA_AREA2_S1_P3);


            Cqm cqm = new Cqm(maquina, date, hora, rd1_1, rd1_2, rd2_1, rd2_2, rd3_1, rd3_2, rd4_1,
                    rd4_2, rd5_1, rd5_2, rd6_1, rd6_2, cham1_1, cham1_2, cham2_1, cham2_2, cham3_1,
                    cham3_2, obs1, obs2, obs3, area1_p1, area1_p2, area1_p3, area2_s4_p1, area2_s4_p2,
                    area2_s4_p3, area2_s3_p1, area2_s3_p2, area2_s3_p3, area2_s2_p1, area2_s2_p2, area2_s2_p3,
                    area2_s1_p1, area2_s1_p2, area2_s1_p3);
            cqmViewModel.insert(cqm);

            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Note not saved!", Toast.LENGTH_LONG).show();
        }
    }
}