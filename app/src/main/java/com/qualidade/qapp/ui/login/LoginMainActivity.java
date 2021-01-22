package com.qualidade.qapp.ui.login;

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
import com.qualidade.qapp.ui.home.HomeActivity;

public class LoginMainActivity extends AppCompatActivity {

    public static final String EXTRA_USER =
            "com.qualidade.qapp.login.EXTRA_USER";

    private Intent intent;
    private LoginViewModel mViewModel;
    private String auditor;
    private TextView textvNew;
    private EditText editUser, editSenha;
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindTest();

        mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(LoginViewModel.class);

        textvNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUser.getText().toString().equals("adm") && editSenha.getText().toString().equals("master")) {
                    intent = new Intent(LoginMainActivity.this, LoginListActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginMainActivity.this, "Insira a senha correta do administrador!", Toast.LENGTH_LONG).show();
                    editUser.setText("");
                    editSenha.setText("");
                }
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mViewModel.getUser(editUser.getText().toString(), editSenha.getText().toString())
                        .observe(LoginMainActivity.this, new Observer<Integer>() {
                            @Override
                            public void onChanged(Integer integer) {
                                if (integer == 1) {
                                    Toast.makeText(LoginMainActivity.this, "Bem vindo!", Toast.LENGTH_LONG).show();
                                    intent = new Intent(LoginMainActivity.this, HomeActivity.class);
                                    auditor = editUser.getText().toString();
                                    intent.putExtra(EXTRA_USER, auditor);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(LoginMainActivity.this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show();
                                    editSenha.setText("");
                                    editUser.setText("");
                                }
                            }
                        });
            }
        });
    }

    /*@Override
    public void bindViews() {
        textvNew = findViewById(R.id.textVNew);
        editUser = findViewById(R.id.editUser);
        editSenha = findViewById(R.id.editPass);
        btnLogar = findViewById(R.id.btnLogar);
    }*/

    public void bindTest() {
        textvNew = findViewById(R.id.textVNew);
        editUser = findViewById(R.id.editUser);
        editSenha = findViewById(R.id.editPass);
        btnLogar = findViewById(R.id.btnLogar);
    }
}