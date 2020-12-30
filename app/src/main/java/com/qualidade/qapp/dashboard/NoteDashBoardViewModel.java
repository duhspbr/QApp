package com.qualidade.qapp.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteDashBoardViewModel extends AndroidViewModel {
    private NoteDashBoardRepository repository;

    public NoteDashBoardViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteDashBoardRepository(application);
    }

    public LiveData<Integer> getCount() { return repository.getCount(); }

    public LiveData<Integer> getCount_psc_status_hoje() { return repository.getCount_psc_status_hoje(); }

    public LiveData<Integer> getCount_psc_status_total_dia_nok() { return repository.getCount_psc_status_total_dia_nok(); }

    public LiveData<Integer> getCount_dod_gav1() { return repository.getCount_dod_gav1(); }

    public LiveData<Integer> getCount_dod_gav2() { return repository.getCount_dod_gav2(); }

    public LiveData<Integer> getCount_dod_entrada() { return repository.getCount_dod_entrada(); }

    public LiveData<Integer> getCount_dod_saida() { return repository.getCount_dod_saida(); }
}
