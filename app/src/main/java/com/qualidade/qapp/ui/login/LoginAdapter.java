package com.qualidade.qapp.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qualidade.qapp.R;
import com.qualidade.qapp.data.models.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.MViewHolder> {
    private List<Login> logins = new ArrayList<>();

    private LoginAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onExcludeClick(int position);
    }

    public void setOnItemClickListener (LoginAdapter.OnItemClickListener listener) { mListener = listener; }

    public static class MViewHolder extends RecyclerView.ViewHolder {
        final private ImageView imgEdit;
        final private ImageView imgExclude;
        final private TextView txtvUser;

        public MViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgExclude = itemView.findViewById(R.id.imgExclude);
            txtvUser = itemView.findViewById(R.id.textvUser);

            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                            //implementar cod para edit
                        }
                    }
                }
            });

            imgExclude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                            //implementar cod para exclusao
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
                .inflate(R.layout.card_list_user, parent, false);
        MViewHolder mViewHolder = new MViewHolder(v, mListener);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Login currentNote = logins.get(position);
        holder.txtvUser.setText(currentNote.getUsuario());

        //holder.textViewDate.setText(currentNote.getDate());
    }

    @Override
    public int getItemCount() {
        return logins.size();
    }

    public void setLogins(List<Login> login) {
        this.logins = login;
        notifyDataSetChanged();
    }
}
