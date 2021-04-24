package com.qualidade.qapp.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.qualidade.qapp.data.models.Login;
import com.qualidade.qapp.data.remote.repository.LoginRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    private LoginRepository repository;
    private LiveData<List<Login>> allUsers;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new LoginRepository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(Login user) { repository.insert(user); }

    public void update(Login user) { repository.update(user); }

    public void delete(Login user) { repository.delete(user); }

    public LiveData<List<Login>> getAllUsers() { return allUsers; }

    public LiveData<Integer> getUser(String user, String senha) { return repository.getUser(user, senha); }
}
