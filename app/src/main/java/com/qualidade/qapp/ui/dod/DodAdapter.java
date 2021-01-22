package com.qualidade.qapp.ui.dod;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Dod;

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
        final private TextView textViewMaquina;
        final private TextView textViewCliente;
        final private TextView textViewCodError;
        final private TextView textViewQuantidade;
        final private TextView textViewGaveta;
        final private TextView textViewTurno;
        final private TextView textViewHora;
        final private TextView textViewData;

        public RelativeLayout relativeLayout_not_expand;
        public RelativeLayout relativeLayout_expand;

        public MViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewCliente = itemView.findViewById(R.id.text_view_cliente);
            textViewGaveta = itemView.findViewById(R.id.text_view_gaveta);
            textViewCodError = itemView.findViewById(R.id.text_view_coderror);
            textViewMaquina = itemView.findViewById(R.id.text_view_maquina);
            textViewQuantidade = itemView.findViewById(R.id.text_view_quantidade);
            textViewTurno = itemView.findViewById(R.id.text_view_turno);
            textViewHora = itemView.findViewById(R.id.text_view_hora);
            textViewData = itemView.findViewById(R.id.text_view_data);

            relativeLayout_not_expand = itemView.findViewById(R.id.relative_view_not_expand1);
            relativeLayout_expand = itemView.findViewById(R.id.relative_view_expand_1);

            relativeLayout_not_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onCardClick(position);

                            if (relativeLayout_expand.getVisibility() == View.GONE) {
                                TransitionManager.beginDelayedTransition(relativeLayout_expand, new AutoTransition());
                                relativeLayout_expand.setVisibility(View.VISIBLE);
                            }
                            else {
                                TransitionManager.beginDelayedTransition(relativeLayout_expand, new AutoTransition());
                                relativeLayout_expand.setVisibility(View.GONE);
                            }
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dod_result, parent, false);
        MViewHolder mViewHolder = new MViewHolder(v, mListener);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Dod currentNote = dods.get(position);
        holder.textViewQuantidade.setText(Integer.toString(currentNote.getQuant()));
        holder.textViewMaquina.setText(currentNote.getStr_dod());
        holder.textViewGaveta.setText(currentNote.getGaveta());
        holder.textViewCliente.setText(currentNote.getCliente());
        holder.textViewTurno.setText(currentNote.getTurno());
        holder.textViewCodError.setText(currentNote.getCod_error());
        holder.textViewHora.setText(currentNote.getHora());
        holder.textViewData.setText(currentNote.getDate());
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
