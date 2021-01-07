package com.qualidade.qapp.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qualidade.qapp.R;
import com.qualidade.qapp.dashboard.NoteDashBoardViewModel;
import com.qualidade.qapp.telainicial.TelaPrincipal;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    LoginViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textvNew = findViewById(R.id.textVNew);
        final EditText editUser = findViewById(R.id.editUser);
        final EditText editSenha = findViewById(R.id.editPass);
        Button btnLogar = findViewById(R.id.btnLogar);

        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(LoginViewModel.class);

        textvNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUser.getText().toString().equals("adm") && editSenha.getText().toString().equals("master")) {
                    intent = new Intent(MainActivity.this, Login_ListaUsers.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Insira a senha correta do administrador!", Toast.LENGTH_LONG).show();
                    editUser.setText("");
                    editSenha.setText("");
                }
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getUser(editUser.getText().toString(), editSenha.getText().toString())
                        .observe(MainActivity.this, new Observer<Integer>() {
                            @Override
                            public void onChanged(Integer integer) {
                                if (integer == 1) {
                                    Toast.makeText(MainActivity.this, "Bem vindo!", Toast.LENGTH_LONG).show();
                                    intent = new Intent(MainActivity.this, TelaPrincipal.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show();
                                    editSenha.setText("");
                                    editUser.setText("");
                                }
                            }
                        });
            }
        });
    }
}