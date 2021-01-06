package com.qualidade.qapp.login;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "login_table")
public class Login {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String usuario;
    private final String senha;
    //private final String date;


    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;

        //this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
