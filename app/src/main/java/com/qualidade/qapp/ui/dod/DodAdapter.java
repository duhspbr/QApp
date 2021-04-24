package com.qualidade.qapp.ui.dod;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Dod;
import com.qualidade.qapp.databinding.ActivityDodRecordBinding;
import com.qualidade.qapp.databinding.CardDodResultBinding;
import com.qualidade.qapp.databinding.CardPscResultBinding;

import java.util.ArrayList;
import java.util.List;

public class DodAdapter extends RecyclerView.Adapter<DodAdapter.MViewHolder> {
    private List<Dod> dods = new ArrayList<>();
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onCardClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) { mListener = listener; }

    public static class MViewHolder extends RecyclerView.ViewHolder {

        private CardDodResultBinding mBinding;

        public MViewHolder(CardDodResultBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dod_result, parent, false);
        CardDodResultBinding binding = CardDodResultBinding.inflate(LayoutInflater.from(parent.getContext()));
        //MViewHolder mViewHolder = new MViewHolder(v, mListener);
        return new MViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {

        final Dod currentNote = dods.get(position);

        holder.mBinding.textViewMaquina.setText(currentNote.getStr_dod());
        holder.mBinding.textViewCliente.setText(currentNote.getCliente());
        holder.mBinding.textViewTurno.setText(currentNote.getTurno());
        holder.mBinding.textViewHora.setText(currentNote.getHora());
        holder.mBinding.textViewData.setText(currentNote.getDate());
    }

    @Override
    public int getItemCount() {
        return dods.size();
    }

    public void setDods(List<Dod> dods) {
        this.dods = dods;
        notifyDataSetChanged();
    }
}
