package com.qualidade.qapp.ui.cqm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Cqm;

import java.util.ArrayList;
import java.util.List;

public class CqmAdapter extends RecyclerView.Adapter<CqmAdapter.MViewHolder> {
    private List<Cqm> cqms = new ArrayList<>();

    public static class MViewHolder extends RecyclerView.ViewHolder {
        final private TextView textViewMaquina;
        final private TextView textViewData;
        final private TextView textViewHora;
        final private TextView textViewStatus;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMaquina = itemView.findViewById(R.id.text_view_status);
            textViewData = itemView.findViewById(R.id.text_view_data);
            textViewHora = itemView.findViewById(R.id.text_view_hora);
            textViewStatus = itemView.findViewById(R.id.text_view_status);
        }

    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_cqm, parent, false);
        MViewHolder mViewHolder = new MViewHolder(v);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Cqm current = cqms.get(position);
        holder.textViewData.setText(current.getData());
        holder.textViewMaquina.setText(current.getMaquina());
        holder.textViewHora.setText(current.getHora());
    }

    @Override
    public int getItemCount() {
        return cqms.size();
    }

    public void setCqms(List<Cqm> cqms) {
        this.cqms = cqms;
        notifyDataSetChanged();
    }
}
