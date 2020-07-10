package com.qualidade.qapp;

public class LoginClass {

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        LoginClass.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static String usuario;
    private String senha;

    public boolean checkLogin() {
        if (usuario.equals("adm") && senha.equals("master")) {
            return true;
        }
        else {
            return false;
        }
    }
}
