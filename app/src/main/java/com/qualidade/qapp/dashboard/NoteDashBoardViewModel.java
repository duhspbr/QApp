package com.qualidade.qapp.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteDashBoardViewModel extends AndroidViewModel {
    private NoteDashBoardRepository repository;
    private LiveData<Integer> allNotesDashBoard;
    private LiveData<Integer> allNotesDashBoard_psc_status_today;

    public NoteDashBoardViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteDashBoardRepository(application);
        allNotesDashBoard = repository.getCount();
        allNotesDashBoard_psc_status_today = repository.getCount_psc_status_totay();
    }

    public LiveData<Integer> getCount() { return repository.getCount(); }

    public LiveData<Integer> getCount_psc_status_totay() { return repository.getCount_psc_status_totay(); }
}
