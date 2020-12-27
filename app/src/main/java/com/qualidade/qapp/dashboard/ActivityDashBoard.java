package com.qualidade.qapp.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.rejeitos_dod.NoteDOD;
import com.qualidade.qapp.rejeitos_dod.NoteDODViewModel;

import java.util.List;

public class ActivityDashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        final TextView text_view_total_psc = findViewById(R.id.text_view_total_psc);
        final TextView text_view_total_psc_totay = findViewById(R.id.text_view_total_psc_nok_today);

        NoteDashBoardViewModel mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteDashBoardViewModel.class);
        mViewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_total_psc.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_psc_status_totay().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_total_psc_totay.setText(String.valueOf(integer));
            }
        });
    }
}