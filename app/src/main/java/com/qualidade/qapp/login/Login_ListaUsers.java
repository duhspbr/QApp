package com.qualidade.qapp.login;

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

public class Login_ListaUsers extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new_user);

        FloatingActionButton buttonAddUser = findViewById(R.id.btn_new);
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_ListaUsers.this, LoginRecord.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcv_login_lista_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final LoginAdapter adapter = new LoginAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new LoginAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {

            }

            @Override
            public void onExcludeClick(int position) {

            }
        });


        loginViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(LoginViewModel.class);
        loginViewModel.getAllUsers().observe(this, new Observer<List<Login>>() {
            @Override
            public void onChanged(List<Login> logins) { adapter.setLogins(logins); }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String user = data.getStringExtra(LoginRecord.EXTRA_USER);
            String senha = data.getStringExtra(LoginRecord.EXTRA_SENHA);

            //String data = data.getStringExtra(FormNewUser.EXTRA_CLIENTE);

            Login login = new Login(user, senha);
            loginViewModel.insert(login);

            Toast.makeText(this, "User saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "User not saved", Toast.LENGTH_LONG).show();
        }
    }
}