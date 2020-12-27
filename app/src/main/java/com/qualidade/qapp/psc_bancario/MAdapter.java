package com.qualidade.qapp.psc_bancario;

import android.graphics.Color;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qualidade.qapp.R;

import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder> {
    private final ArrayList<com.qualidade.qapp.psc_bancario.ItemCard> mItemCards;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onCardClick(int position);
        void onBtnOKClick(int position);
        void onBtnNOKClick(int position);
        void onBtnClearClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) { mListener = listener; }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public View mViewPanel;
        public RelativeLayout relativeLayout_1;
        public RelativeLayout relativeLayout_expand;
        public FloatingActionButton btnOK;
        public FloatingActionButton btnNOK;
        public FloatingActionButton btnClear;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.textvItem);
            mTextView2 = itemView.findViewById(R.id.textvponto);
            mTextView3 = itemView.findViewById(R.id.textvDescr);
            mViewPanel = itemView.findViewById(R.id.panelStatus);
            relativeLayout_1 = itemView.findViewById(R.id.relative_view_1);
            relativeLayout_expand = itemView.findViewById(R.id.relative_view_expand);
            btnOK = itemView.findViewById(R.id.btn_ok);
            btnNOK = itemView.findViewById(R.id.btn_nok);
            btnClear = itemView.findViewById(R.id.btn_clear);

            relativeLayout_1.setOnClickListener(new View.OnClickListener() {
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

            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBtnOKClick(position);

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

            btnNOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBtnNOKClick(position);

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

            btnClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBtnClearClick(position);

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

    public MAdapter(ArrayList<com.qualidade.qapp.psc_bancario.ItemCard> itemCards) {
        mItemCards = itemCards;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_psc, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, mListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemCard currentItem = mItemCards.get(position);

        holder.mTextView1.setText(currentItem.getMtext1());
        holder.mTextView2.setText(currentItem.getMtext2());
        holder.mTextView3.setText(currentItem.getMtext3());
        holder.mViewPanel.setBackgroundColor(currentItem.getMColor());
    }

    @Override
    public int getItemCount() {
        return mItemCards.size();
    }
}
