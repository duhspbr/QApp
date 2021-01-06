package com.qualidade.qapp.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.qualidade.qapp.rejeitos_dod.NoteDOD;
import com.qualidade.qapp.rejeitos_dod.NoteDODRepository;

import java.util.List;

public class LoginViewModel {

    private NoteDODRepository repository;
    private LiveData<List<NoteDOD>> allNotesDod;

    public NoteDODViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteDODRepository(application);
        allNotesDod = repository.getAllNotesDod();
    }

    public void insert(NoteDOD noteDOD) { repository.insert(noteDOD); }

    public void update(NoteDOD noteDOD) { repository.update(noteDOD); }

    public void delete(NoteDOD noteDOD) { repository.delete(noteDOD); }

    public void deleteAllNotesDOD(NoteDOD noteDOD) { repository.deleteAllNotesDod(); }

    public LiveData<List<NoteDOD>> getAllNotesDod() { return allNotesDod; }
}
