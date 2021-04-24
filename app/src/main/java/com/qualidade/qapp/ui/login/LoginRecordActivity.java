package com.qualidade.qapp.ui.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;
import com.qualidade.qapp.databinding.ActivityLoginRecordBinding;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.widget.Toast.makeText;

public class LoginRecordActivity extends AppCompatActivity {
    public static final String EXTRA_USER =
            "com.qualidade.qapp.login.EXTRA_USER";

    public static final String EXTRA_SENHA =
            "com.qualidade.qapp.login.EXTRA_SENHA";

    private final ActivityLoginRecordBinding binding = ActivityLoginRecordBinding.inflate(getLayoutInflater());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
            }
        });
    }

    public void saveUser() {
        String usuario = binding.editUser.getText().toString();
        String senha = binding.editSenha.getText().toString();
        String confirmSenha = binding.editConfirmar.getText().toString();

        if (usuario.trim().isEmpty() || senha.trim().isEmpty() || confirmSenha.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!senha.equals(confirmSenha)) {
            Toast.makeText(this, "Senhas divergentes!", Toast.LENGTH_SHORT).show();
        } else {
            Intent data = new Intent();
            data.putExtra(EXTRA_USER, usuario);
            data.putExtra(EXTRA_SENHA, senha);

            setResult(RESULT_OK, data);
            finish();
        }
    }
}