package com.qualidade.qapp.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.qualidade.qapp.rejeitos_dod.NoteDOD;
import com.qualidade.qapp.rejeitos_dod.NoteDODRepository;

import java.util.List;

public class LoginViewModel {

    private LoginRepository repository;
    private LiveData<List<Login>> allUsers;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new LoginRepository(application);
        allUsers = repository.getAllUsers();
    }

    public void insert(Login login) { repository.insert(login); }

    public void update(Login login) { repository.update(login); }

    public void delete(Login login) { repository.delete(login); }

    public void deleteAllUsers(Login login) { repository.deleteAllUsers(); }

    public LiveData<List<Login>> getAllUsers() { return allUsers; }
}
