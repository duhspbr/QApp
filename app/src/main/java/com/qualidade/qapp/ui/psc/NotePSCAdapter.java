package com.qualidade.qapp.ui.psc;

import android.graphics.Color;
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
import com.qualidade.qapp.data.models.Psc;

import java.util.ArrayList;
import java.util.List;

public class NotePSCAdapter extends RecyclerView.Adapter<NotePSCAdapter.MViewHolder> {
    private List<Psc> psc = new ArrayList<>();

    private NotePSCAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onCardClick(int position);
    }

    public void setOnItemClickListener (NotePSCAdapter.OnItemClickListener listener) { mListener = listener; }

    public static class MViewHolder extends RecyclerView.ViewHolder {
        final private TextView textViewItem;
        final private TextView textViewCliente;
        final private TextView textViewProduto;
        final private TextView textViewQuantidade;
        final private TextView textViewIdOrdem;
        final private TextView textViewTurno;
        final private TextView textViewStatus;
        final private TextView textViewDate;
        final private TextView textViewHora;

        public RelativeLayout relativeLayout_not_expand;
        public RelativeLayout relativeLayout_expand;

        public MViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewCliente = itemView.findViewById(R.id.text_view_cliente);
            textViewProduto = itemView.findViewById(R.id.text_view_produto);
            textViewIdOrdem = itemView.findViewById(R.id.text_view_id_ordem);
            textViewStatus = itemView.findViewById(R.id.text_view_status);
            textViewQuantidade = itemView.findViewById(R.id.text_view_quantidade);
            textViewTurno = itemView.findViewById(R.id.text_view_turno);
            textViewItem = itemView.findViewById(R.id.text_view_item);
            textViewDate = itemView.findViewById(R.id.text_view_data);
            textViewHora = itemView.findViewById(R.id.text_view_hora);

            relativeLayout_not_expand = itemView.findViewById(R.id.relative_view_not_expand2);
            relativeLayout_expand = itemView.findViewById(R.id.relative_expand_2);

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
                .inflate(R.layout.card_psc_result, parent, false);
        MViewHolder mViewHolder = new MViewHolder(v, mListener);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Psc currentNote = psc.get(position);
        holder.textViewQuantidade.setText(currentNote.getQtde_amostra());
        holder.textViewProduto.setText(currentNote.getProd_audit());
        holder.textViewItem.setText(currentNote.getItem());
        holder.textViewIdOrdem.setText(currentNote.getId_ordem());
        holder.textViewCliente.setText(currentNote.getCliente());
        holder.textViewTurno.setText(currentNote.getTurno());
        holder.textViewStatus.setText(currentNote.getStatus());
        holder.textViewDate.setText(currentNote.getDate());
        holder.textViewHora.setText(currentNote.getHora());

        if (psc.get(position).getStatus().equals("OK")) {
            holder.textViewStatus.setTextColor(Color.parseColor("#93C47D"));
        }
        else if (psc.get(position).getStatus().equals("NOK")) {
            holder.textViewStatus.setTextColor(Color.parseColor("#CC0000"));
        }
    }

    @Override
    public int getItemCount() {
        return psc.size();
    }

    public void setPsc(List<Psc> psc) {
        this.psc = psc;
        notifyDataSetChanged();
    }
}
