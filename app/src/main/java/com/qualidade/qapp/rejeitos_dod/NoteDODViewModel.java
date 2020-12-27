package com.qualidade.qapp.rejeitos_dod;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteDODViewModel extends AndroidViewModel {
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
