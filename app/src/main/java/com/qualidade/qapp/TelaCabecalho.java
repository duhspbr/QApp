package com.qualidade.qapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.TimeZone;


import org.w3c.dom.Text;

public class TelaCabecalho extends AppCompatActivity {


    LocalDateTime today;
    String data = "";
    String horaInicio = "";
    Processar processar = new Processar();

    Spinner spinnerClientes = null;
    Spinner spinnerTurno = null;
    Spinner spinnerLinha = null;
    TextView textViewHoraInicio = null;
    TextView textViewData = null;
    EditText editTextProdutoAudit = null;
    EditText editTextID = null;
    EditText editTextQtdeLote = null;
    EditText editTextQtde = null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cabecalho);

        spinnerClientes = (Spinner) findViewById(R.id.spinner_clientes);
        ArrayAdapter<CharSequence> adapter_clientes = ArrayAdapter.createFromResource(this, R.array.clientes, android.R.layout.simple_spinner_dropdown_item);
        adapter_clientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(adapter_clientes);

        spinnerTurno = (Spinner) findViewById(R.id.spinner_turno);
        ArrayAdapter<CharSequence> adapter_turno = ArrayAdapter.createFromResource(this, R.array.turno, android.R.layout.simple_spinner_dropdown_item);
        adapter_turno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurno.setAdapter(adapter_turno);

        spinnerLinha = (Spinner) findViewById(R.id.spinner_linha);
        ArrayAdapter<CharSequence> adapter_linha = ArrayAdapter.createFromResource(this, R.array.linha, android.R.layout.simple_spinner_dropdown_item);
        adapter_linha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLinha.setAdapter(adapter_linha);

        textViewData = (TextView)findViewById(R.id.textViewData);
        data = LocalDate.now().toString();
        textViewData.setText(data);

        textViewHoraInicio = (TextView)findViewById(R.id.textViewHoraInicio);
        textViewHoraInicio.setText(processar.getHora());
    }

    public void chamartelaAuditPSC(View view) {
        ClassCabecalho classCabecalho = new ClassCabecalho();

        spinnerClientes = (Spinner) findViewById(R.id.spinner_clientes);
        classCabecalho.setCliente(spinnerClientes.getSelectedItem().toString());

        spinnerTurno = (Spinner) findViewById(R.id.spinner_turno);
        classCabecalho.setTurno(spinnerTurno.getSelectedItem().toString());

        spinnerLinha = (Spinner) findViewById(R.id.spinner_linha);
        classCabecalho.setLinha(spinnerLinha.getSelectedItem().toString());

        editTextProdutoAudit = (EditText) findViewById(R.id.editTextProdutoAudit);
        classCabecalho.setProduto(editTextProdutoAudit.getText().toString());

        editTextID = (EditText) findViewById(R.id.editTextID);
        classCabecalho.setId(editTextID.getText().toString());

        editTextQtdeLote = (EditText) findViewById(R.id.editTextQtdeLote);
        classCabecalho.setQtdeLote(editTextQtdeLote.getText().toString());

        editTextQtde = (EditText) findViewById(R.id.editTextQtde);
        classCabecalho.setQtde(editTextQtde.getText().toString());

        Intent intent = new Intent(this, TelaAuditPsc.class);
        startActivity(intent);
    }

    public void chamartelaPrincipal(View view) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }
}