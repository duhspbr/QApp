package com.qualidade.qapp.ui.dod;

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
import com.qualidade.qapp.data.models.Dod;
import com.qualidade.qapp.ui.home.HomeActivity;

import java.util.List;

public class DodListActivity extends AppCompatActivity {

    public static final int ADD_NOTE_REQUEST = 1;

    private NoteDODViewModel noteDODViewModel;
    private String auditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dod_result);

        Intent intent = getIntent();
        auditor = intent.getStringExtra(HomeActivity.EXTRA_USER);

        FloatingActionButton buttonAddNote = findViewById(R.id.btn_new);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DodListActivity.this, DodRecordActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcv_dod);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final DodAdapter adapter = new DodAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new DodAdapter.OnItemClickListener() {
            @Override
            public void onCardClick(int position) {

            }
        });

        noteDODViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteDODViewModel.class);
        noteDODViewModel.getAllNotesDod().observe(this, new Observer<List<Dod>>() {
            @Override
            public void onChanged(List<Dod> dods) { adapter.setDods(dods); }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String maquina = data.getStringExtra(DodRecordActivity.EXTRA_MAQUINA);
            String cliente = data.getStringExtra(DodRecordActivity.EXTRA_CLIENTE);
            int quantidade = Integer.parseInt(data.getStringExtra(DodRecordActivity.EXTRA_QUANTIDADE));
            String codError = data.getStringExtra(DodRecordActivity.EXTRA_CODEERROR);
            String turno = data.getStringExtra(DodRecordActivity.EXTRA_TURNO);
            String gaveta = data.getStringExtra(DodRecordActivity.EXTRA_GAVETA);
            String data_n = data.getStringExtra(DodRecordActivity.EXTRA_DATA);
            String hora = data.getStringExtra(DodRecordActivity.EXTRA_HORA);

            Dod dod = new Dod(auditor, cliente, maquina, turno, gaveta, codError, quantidade, data_n, hora);
            noteDODViewModel.insert(dod);

            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_LONG).show();
        }
    }
}