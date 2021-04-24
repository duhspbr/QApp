package com.qualidade.qapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qualidade.qapp.R;
import com.qualidade.qapp.databinding.ActivityLoginBinding;
import com.qualidade.qapp.ui.home.HomeActivity;
import com.qualidade.qapp.utils.Constants;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getUser(
                        binding.editUser.getText().toString(), binding.editPass.getText().toString()).observe(
                        LoginActivity.this, new Observer<Integer>() {
                            @Override
                            public void onChanged(Integer integer) {
                                if (integer == 1) {
                                    Toast.makeText(getApplicationContext(), "Bem Vindo!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                                } else {
                                    Toast.makeText(getApplicationContext(), "Falha de Acesso!", Toast.LENGTH_LONG).show();
                                    binding.editUser.setText("");
                                    binding.editPass.setText("");
                                }
                            }
                        });
            }
        });

        binding.textVNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editPass.getText().toString().equals(Constants.USER_MASTER) &&
                        binding.editUser.getText().toString().equals(Constants.SENHA_MASTER)) {
                    startActivity(new Intent(LoginActivity.this, LoginListActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Falha de Acesso!", Toast.LENGTH_LONG).show();
                    binding.editUser.setText("");
                    binding.editPass.setText("");
                }
            }
        });
    }
}