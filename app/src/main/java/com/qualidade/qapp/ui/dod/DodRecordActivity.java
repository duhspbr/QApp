package com.qualidade.qapp.ui.dod;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;
import com.qualidade.qapp.databinding.ActivityDodRecordBinding;
import com.qualidade.qapp.databinding.ActivityMainscreenBinding;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.widget.Toast.makeText;

public class DodRecordActivity extends AppCompatActivity {
    public static final String EXTRA_MAQUINA =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_MAQUINA";

    public static final String EXTRA_CLIENTE =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_CLIENTE";

    public static final String EXTRA_TURNO =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_TURNO";

    public static final String EXTRA_QUANTIDADE =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_QUANTIDADE";

    public static final String EXTRA_CODEERROR =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_CODEERROR";

    public static final String EXTRA_GAVETA =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_GAVETA";

    public static final String EXTRA_HORA =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_HORA";

    public static final String EXTRA_DATA =
            "com.qualidade.qapp.rejeitos_dod.EXTRA_DATA";

    private EditText editTextQuantidade;
    private Spinner spinnerCliente;
    private Spinner spinnerMaquina;
    private Spinner spinnerTurno;
    private Spinner spinnerGaveta;
    private Spinner spinnerCodError;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDodRecordBinding biding = ActivityDodRecordBinding.inflate(getLayoutInflater());
        setContentView(biding.getRoot());

        carregaSpinners();

        editTextQuantidade = findViewById(R.id.editTextQtde);
        spinnerCliente = findViewById(R.id.spinner_clientes);
        spinnerMaquina = findViewById(R.id.spinner_maquina);
        spinnerTurno = findViewById(R.id.spinner_turno);
        spinnerGaveta = findViewById(R.id.spinner_gaveta);
        spinnerCodError = findViewById(R.id.spinner_cod_error);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void saveNoteDod() {

        calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String _data = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("HH:mm");
        String _hora = dateFormat.format(calendar.getTime());

        String cliente = spinnerCliente.getSelectedItem().toString();
        String maquina = spinnerMaquina.getSelectedItem().toString();
        String turno = spinnerTurno.getSelectedItem().toString();
        String gaveta = spinnerGaveta.getSelectedItem().toString();
        String codError = spinnerCodError.getSelectedItem().toString();
        String quantidade = editTextQuantidade.getText().toString();
        String hora = _hora;
        String data_n = _data;

        if (cliente.trim().isEmpty() || maquina.trim().isEmpty() || turno.trim().isEmpty()
        || gaveta.trim().isEmpty() || codError.trim().isEmpty() || quantidade.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_MAQUINA, maquina);
        data.putExtra(EXTRA_CLIENTE, cliente);
        data.putExtra(EXTRA_TURNO, turno);
        data.putExtra(EXTRA_GAVETA, gaveta);
        data.putExtra(EXTRA_CODEERROR, codError);
        data.putExtra(EXTRA_QUANTIDADE, quantidade);
        data.putExtra(EXTRA_DATA, _data.replace("-", "/"));
        data.putExtra(EXTRA_HORA, _hora);

        setResult(RESULT_OK, data);
        finish();
    }

    public void carregaSpinners() {
        Spinner spinnerClientes = findViewById(R.id.spinner_clientes);
        ArrayAdapter<CharSequence> adapter_clientes = ArrayAdapter.createFromResource(this, R.array.clientes, android.R.layout.simple_spinner_dropdown_item);
        adapter_clientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(adapter_clientes);

        Spinner spinnerCod = findViewById(R.id.spinner_cod_error);
        ArrayAdapter<CharSequence> adpter_cod = ArrayAdapter.createFromResource(this, R.array.cod, android.R.layout.simple_spinner_dropdown_item);
        adpter_cod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCod.setAdapter(adpter_cod);

        Spinner spinnerDod = findViewById(R.id.spinner_maquina);
        ArrayAdapter<CharSequence> adapter_dod = ArrayAdapter.createFromResource(this, R.array.dod, android.R.layout.simple_spinner_dropdown_item);
        adapter_dod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDod.setAdapter(adapter_dod);

        Spinner spinnerTurno = findViewById(R.id.spinner_turno);
        ArrayAdapter<CharSequence> adapter_turno = ArrayAdapter.createFromResource(this, R.array.turno, android.R.layout.simple_spinner_dropdown_item);
        adapter_turno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurno.setAdapter(adapter_turno);

        Spinner spinnerGaveta = findViewById(R.id.spinner_gaveta);
        ArrayAdapter<CharSequence> adapter_gaveta = ArrayAdapter.createFromResource(this, R.array.gaveta, android.R.layout.simple_spinner_dropdown_item);
        adapter_gaveta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGaveta.setAdapter(adapter_gaveta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.psc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveNoteDod();
                return true;

            case R.id.action_cancel:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}