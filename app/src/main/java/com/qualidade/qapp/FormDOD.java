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
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

import static android.widget.Toast.makeText;

public class FormDOD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_d_o_d);

        Spinner spinnerClientes = (Spinner) findViewById(R.id.spinner_clientes);
        ArrayAdapter<CharSequence> adapter_clientes = ArrayAdapter.createFromResource(this, R.array.clientes, android.R.layout.simple_spinner_dropdown_item);
        adapter_clientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(adapter_clientes);

        Spinner spinnerCod = (Spinner) findViewById(R.id.spinner_cod);
        ArrayAdapter<CharSequence> adpter_cod = ArrayAdapter.createFromResource(this, R.array.cod, android.R.layout.simple_spinner_dropdown_item);
        adpter_cod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCod.setAdapter(adpter_cod);

        Spinner spinnerDod = (Spinner) findViewById(R.id.spinner_dod);
        ArrayAdapter<CharSequence> adapter_dod = ArrayAdapter.createFromResource(this, R.array.dod, android.R.layout.simple_spinner_dropdown_item);
        adapter_dod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDod.setAdapter(adapter_dod);

        Spinner spinnerTurno = (Spinner) findViewById(R.id.spinner_turno);
        ArrayAdapter<CharSequence> adapter_turno = ArrayAdapter.createFromResource(this, R.array.turno, android.R.layout.simple_spinner_dropdown_item);
        adapter_turno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurno.setAdapter(adapter_turno);

        Spinner spinnerGaveta = (Spinner) findViewById(R.id.spinner_gaveta);
        ArrayAdapter<CharSequence> adapter_gaveta = ArrayAdapter.createFromResource(this, R.array.gaveta, android.R.layout.simple_spinner_dropdown_item);
        adapter_gaveta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGaveta.setAdapter(adapter_gaveta);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void gravarDados(View view) throws IOException {
        Processar processar = new Processar();
        ClassDOD classDOD = new ClassDOD();
        String FILE_NAME = "dod_" + processar.getData() + "_" + processar.getHoraArq() + ".txt";
        Intent intent = new Intent(this, TelaPrincipal.class);
        LoginClass loginClass = new LoginClass();

        Spinner spinnerClientes = (Spinner) findViewById(R.id.spinner_clientes);
        Spinner spinnerTurno = (Spinner) findViewById(R.id.spinner_turno);
        Spinner spinnerGaveta = (Spinner) findViewById(R.id.spinner_gaveta);
        Spinner spinnerCod = (Spinner) findViewById(R.id.spinner_cod);
        EditText editTextQtd = (EditText) findViewById(R.id.editTextQtde);

        classDOD.setAuditor(loginClass.usuario);
        classDOD.setCliente(spinnerClientes.getSelectedItem().toString());
        classDOD.setTurno(spinnerTurno.getSelectedItem().toString());
        classDOD.setGaveta(spinnerGaveta.getSelectedItem().toString());
        classDOD.setCod_erro(spinnerCod.getSelectedItem().toString());
        classDOD.setQtd(editTextQtd.getText().toString());
        classDOD.setHora(processar.getHora());
        classDOD.setData(processar.getData());

        String text = classDOD.getAuditor() + "," + classDOD.getCliente() + "," + classDOD.getTurno() + "," + classDOD.getGaveta() + "," + classDOD.getCod_erro() +
                "," + classDOD.getQtd() + "," + classDOD.getHora() + "," + classDOD.getData();

        FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
        fos.write(text.getBytes());
        makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    public void chamarTelaPrincipal(View view) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }
}