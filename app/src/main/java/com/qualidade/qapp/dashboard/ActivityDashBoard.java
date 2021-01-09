package com.qualidade.qapp.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.rejeitos_dod.NoteDOD;
import com.qualidade.qapp.rejeitos_dod.NoteDODViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class ActivityDashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        final TextView text_view_total_psc = findViewById(R.id.text_view_total_psc);
        final TextView text_view_total_psc_nok_today = findViewById(R.id.text_view_total_psc_nok_today);

        final TextView text_view_dod_gav1 = findViewById(R.id.text_view_gav1);
        final TextView text_view_dod_gav2 = findViewById(R.id.text_view_gav2);
        final TextView text_view_dod_pEntrada = findViewById(R.id.text_view_pack_entrada);
        final TextView text_view_dod_pSaida = findViewById(R.id.text_view_pack_saida);

        NoteDashBoardViewModel mViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NoteDashBoardViewModel.class);
        mViewModel.getCount_psc_status_hoje().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_total_psc.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_psc_status_total_dia_nok().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_total_psc_nok_today.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_dod_gav1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_dod_gav1.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_dod_gav2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_dod_gav2.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_dod_entrada().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_dod_pEntrada.setText(String.valueOf(integer));
            }
        });

        mViewModel.getCount_dod_saida().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                text_view_dod_pSaida.setText(String.valueOf(integer));
            }
        });

    }
}