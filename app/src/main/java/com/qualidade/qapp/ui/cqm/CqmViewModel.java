package com.qualidade.qapp.ui.cqm;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.qualidade.qapp.data.models.Cqm;
import com.qualidade.qapp.data.remote.repository.CqmRepository;

import java.util.List;

public class CqmViewModel extends AndroidViewModel {
    private CqmRepository repository;
    private LiveData<List<Cqm>> allCqm;

    public CqmViewModel(@NonNull Application application) {
        super(application);
        repository = new CqmRepository(application);
        allCqm = repository.getAllCqm();
    }

    public void insert(Cqm cqm) { repository.insert(cqm); }
    public LiveData<List<Cqm>> getAllCqm() { return allCqm; }
}
