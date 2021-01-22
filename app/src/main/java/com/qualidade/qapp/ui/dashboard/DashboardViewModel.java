package com.qualidade.qapp.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.qualidade.qapp.data.remote.repository.DashboardRepository;

public class DashboardViewModel extends AndroidViewModel {
    private DashboardRepository repository;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        repository = new DashboardRepository(application);
    }

    public LiveData<Integer> getCount() { return repository.getCount(); }

    public LiveData<Integer> getCount_psc_status_hoje() { return repository.getCount_psc_status_hoje(); }

    public LiveData<Integer> getCount_psc_status_total_dia_nok() { return repository.getCount_psc_status_total_dia_nok(); }

    public LiveData<Integer> getCount_dod_gav1() { return repository.getCount_dod_gav1(); }

    public LiveData<Integer> getCount_dod_gav2() { return repository.getCount_dod_gav2(); }

    public LiveData<Integer> getCount_dod_entrada() { return repository.getCount_dod_entrada(); }

    public LiveData<Integer> getCount_dod_saida() { return repository.getCount_dod_saida(); }
}
