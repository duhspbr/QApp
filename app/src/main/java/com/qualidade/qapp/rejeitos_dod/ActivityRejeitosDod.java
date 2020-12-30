package com.qualidade.qapp.rejeitos_dod;

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

import java.util.List;

public class ActivityRejeitosDod extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;

    private NoteDODViewModel noteDODViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dod_result);

        FloatingActionButton buttonAddNote = findViewById(R.id.btn_new);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRejeitosDod.this, FormDOD.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcv_dod);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteDodAdapter adapter = new NoteDodAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new NoteDodAdapter.OnItemClickListener() {
            @Override
            public void onCardClick(int position) {

            }
        });

        noteDODViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteDODViewModel.class);
        noteDODViewModel.getAllNotesDod().observe(this, new Observer<List<NoteDOD>>() {
            @Override
            public void onChanged(List<NoteDOD> noteDODS) { adapter.setNoteDODS(noteDODS); }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String maquina = data.getStringExtra(FormDOD.EXTRA_MAQUINA);
            String cliente = data.getStringExtra(FormDOD.EXTRA_CLIENTE);
            int quantidade = Integer.parseInt(data.getStringExtra(FormDOD.EXTRA_QUANTIDADE));
            String codError = data.getStringExtra(FormDOD.EXTRA_CODEERROR);
            String turno = data.getStringExtra(FormDOD.EXTRA_TURNO);
            String gaveta = data.getStringExtra(FormDOD.EXTRA_GAVETA);
            String data_n = data.getStringExtra(FormDOD.EXTRA_DATA);
            String hora = data.getStringExtra(FormDOD.EXTRA_HORA);

            NoteDOD noteDOD = new NoteDOD(cliente, maquina, turno, gaveta, codError, quantidade, data_n, hora);
            noteDODViewModel.insert(noteDOD);

            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_LONG).show();
        }
    }
}