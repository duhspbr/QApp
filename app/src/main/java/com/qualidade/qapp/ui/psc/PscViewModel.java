package com.qualidade.qapp.ui.psc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.models.Psc;
import com.qualidade.qapp.data.remote.repository.PscRepository;

import java.util.List;

public class PscViewModel extends AndroidViewModel {
    private PscRepository repository;
    private LiveData<List<Psc>> allNotesPsc;

    public PscViewModel(@NonNull Application application) {
        super(application);
        repository = new PscRepository(application);
        allNotesPsc = repository.getAllNotesPsc();
    }

    public LiveData<List<Psc>> getAllNotes() {
        return allNotesPsc;
    }

    public void insert(Psc psc) { repository.insert(psc); }

    public void update(Psc psc) { repository.update(psc); }

    public void delete(Psc psc) { repository.delete(psc); }

    public void deleteAllNotesPSC(Psc psc) { repository.deleteAllNotesPsc(); }

    public LiveData<List<Psc>> getAllNotesPsc() { return allNotesPsc; }
}
