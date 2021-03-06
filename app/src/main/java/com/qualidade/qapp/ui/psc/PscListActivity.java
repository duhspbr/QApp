package com.qualidade.qapp.ui.psc;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Psc;
import com.qualidade.qapp.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class PscListActivity extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;
    private ArrayList<ItemCard> itemCard;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String auditor;
    Intent intent;

    private PscViewModel pscViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psc_result);

        intent = getIntent();
        auditor = intent.getStringExtra(HomeActivity.EXTRA_USER);

        FloatingActionButton buttonAddNote = findViewById(R.id.btn_new);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PscListActivity.this, PscRecordActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.rcv_psc_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NotePSCAdapter adapter = new NotePSCAdapter(getApplicationContext(), getApplication());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new NotePSCAdapter.OnItemClickListener() {
            @Override
            public void onCardClick(int position) {

            }
        });

        pscViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(PscViewModel.class);
        pscViewModel.getAllNotesPsc().observe(this, new Observer<List<Psc>>() {
            @Override
            public void onChanged(List<Psc> pscs) { adapter.setPsc(pscs); }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String _data = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("HH:mm");
        String _hora = dateFormat.format(calendar.getTime());
        

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {

            String linha = data.getStringExtra(PscRecordActivity.EXTRA_LINHA);
            String cliente = data.getStringExtra(PscRecordActivity.EXTRA_CLIENTE);
            String quantidade_a = data.getStringExtra(PscRecordActivity.EXTRA_QUANTIDADE_A);
            String quantidade_l = data.getStringExtra(PscRecordActivity.EXTRA_QUANTIDADE_L);
            String produto = data.getStringExtra(PscRecordActivity.EXTRA_PRODUTO);
            String turno = data.getStringExtra(PscRecordActivity.EXTRA_TURNO);
            HashMap<String, ListaItens> item = (HashMap<String, ListaItens>) data.getSerializableExtra(PscRecordActivity.EXTRA_ITEM);
            String id_ordem = data.getStringExtra(PscRecordActivity.EXTRA_ID_ORDEM);

            for (ListaItens keys: item.values()) {

                Psc psc = new Psc(auditor, turno, linha, cliente, produto, id_ordem, quantidade_l,
                        quantidade_a, checkItem(Integer.parseInt(keys.getItem())), keys.getStatus(), _data.replace("-", "/"), _hora);
                pscViewModel.insert(psc);
            }
            Toast.makeText(this, "Note saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_LONG).show();
        }
    }

    public String checkItem(int i) {
        switch (i) {
            case 1:
                return "1. PERSO/BH/MANUSEIO/AGILI";

            case 2:
                return "2. PERSO/BH/MANUSEIO/AGILI";

            case 3:
                return "3. PERSONALIZAÇÃO";

            case 4:
                return "4. PERSONALIZAÇÃO";

            case 5:
                return "5. PERSONALIZAÇÃO";

            case 6:
                return "6. MANUSEIO (DC/ MX/ BH)";

            case 7:
                return "7. MANUSEIO (DC/ MX/ BH)";

            case 8:
                return "8. MANUSEIO (DC/ MX/ BH)";

            case 9:
                return "9. MANUSEIO (DC/ MX/ BH)";

            case 10:
                return "10. MANUSEIO (DC/ MX/ BH)";

            case 11:
                return "11. BELL & HOWELL";

            case 12:
                return "12. RETRABALHO (PRODUÇÃO)";

            case 13:
                return "13. RETRABALHO (PRODUÇÃO)";

            case 14:
                return "14. ROTERIZAÇÃO";

            case 15:
                return "15. ROTERIZAÇÃO";

            case 16:
                return "16. ROTERIZAÇÃO";

            case 17:
                return "17. AGILIZAÇÃO DUPLA CUSTÓDIA";

            case 18:
                return "18. PERSO/BH/MANUSEIO/AGILI";

            case 19:
                return "19. PERSONALIZAÇÃO (LIMPEZA DAS MÁQUINAS)";
        }
        return "string";
    }
}