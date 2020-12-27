package com.qualidade.qapp.psc_bancario;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotePSCViewModel extends AndroidViewModel {
    private NotePSCRepository repository;
    private LiveData<List<NotePSC>> allNotesPsc;

    public NotePSCViewModel(@NonNull Application application) {
        super(application);
        repository = new NotePSCRepository(application);
        allNotesPsc = repository.getAllNotesPsc();
    }

    public LiveData<List<NotePSC>> getAllNotes() {
        return allNotesPsc;
    }

    public void insert(NotePSC notePSC) { repository.insert(notePSC); }

    public void update(NotePSC notePSC) { repository.update(notePSC); }

    public void delete(NotePSC notePSC) { repository.delete(notePSC); }

    public void deleteAllNotesPSC(NotePSC notePSC) { repository.deleteAllNotesPsc(); }

    public LiveData<List<NotePSC>> getAllNotesPsc() { return allNotesPsc; }
}
