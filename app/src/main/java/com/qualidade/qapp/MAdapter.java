package com.qualidade.qapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder> {
    private ArrayList<ItemCard> mItemCards;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onBtnOKClick(int position);
        void onBtnNOKClick(int position);
        void onCardClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public Button mButtonOK;
        public Button mButtonNOK;
        public View mViewPanel;
        public CardView mCardV;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mButtonOK = itemView.findViewById(R.id.btnOK);
            mButtonNOK = itemView.findViewById(R.id.btnNOK);
            mTextView1 = itemView.findViewById(R.id.textvItem);
            mTextView2 = itemView.findViewById(R.id.textvponto);
            mTextView3 = itemView.findViewById(R.id.textvDescr);
            mViewPanel = itemView.findViewById(R.id.panelStatus);
            mCardV = itemView.findViewById(R.id.cardITem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mButtonOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBtnOKClick(position);
                        }
                    }
                }
            });

            mButtonNOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onBtnNOKClick(position);
                        }
                    }
                }
            });

            mCardV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onCardClick(position);
                        }
                    }
                }
            });
        }
    }

    public MAdapter(ArrayList<ItemCard> itemCards) {
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
