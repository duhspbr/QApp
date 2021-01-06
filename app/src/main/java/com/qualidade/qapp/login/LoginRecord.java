package com.qualidade.qapp.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.widget.Toast.makeText;

public class LoginRecord extends AppCompatActivity {
    public static final String EXTRA_USER =
            "com.qualidade.qapp.login.EXTRA_USER";

    public static final String EXTRA_SENHA =
            "com.qualidade.qapp.login.EXTRA_SENHA";

    private EditText editUser;
    private EditText editSenha;
    private EditText editConfirmSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_record);

        editUser = findViewById(R.id.editUser);
        editSenha = findViewById(R.id.editSenha);
        editConfirmSenha = findViewById(R.id.editConfirmar);

        FloatingActionButton floatingActionButtonOK = findViewById(R.id.btnOK);

        floatingActionButtonOK.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                saveUser();
            }
        });
    }

    public void saveUser() {

        String usuario = editUser.getText().toString();
        String senha = editSenha.getText().toString();
        String confirmSenha = editConfirmSenha.getText().toString();

        if (usuario.trim().isEmpty() || senha.trim().isEmpty() || confirmSenha.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!senha.equals(confirmSenha)) {
            Toast.makeText(this, "Senhas divergentes!", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent data = new Intent();
            data.putExtra(EXTRA_USER, usuario);
            data.putExtra(EXTRA_SENHA, senha);

            setResult(RESULT_OK, data);
            finish();
        }
    }
}