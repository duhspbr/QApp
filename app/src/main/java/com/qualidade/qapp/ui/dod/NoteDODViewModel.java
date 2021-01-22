package com.qualidade.qapp.ui.dod;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.models.Dod;
import com.qualidade.qapp.data.remote.repository.DodRepository;

import java.util.List;

public class NoteDODViewModel extends AndroidViewModel {
    private DodRepository repository;
    private LiveData<List<Dod>> allNotesDod;

    public NoteDODViewModel(@NonNull Application application) {
        super(application);
        repository = new DodRepository(application);
        allNotesDod = repository.getAllNotesDod();
    }

    public void insert(Dod dod) { repository.insert(dod); }

    public void update(Dod dod) { repository.update(dod); }

    public void delete(Dod dod) { repository.delete(dod); }

    public void deleteAllNotesDOD(Dod dod) { repository.deleteAllNotesDod(); }

    public LiveData<List<Dod>> getAllNotesDod() { return allNotesDod; }
}
