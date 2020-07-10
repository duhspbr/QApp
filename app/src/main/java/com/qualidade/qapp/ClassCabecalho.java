package com.qualidade.qapp;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ClassCabecalho {

    private static String turno;
    private static String linha;
    private static String produto;
    private static String id;
    private static String cliente;
    private static String qtdeLote;
    private static String qtde;

    public static String getTurno() {
        return turno;
    }

    public static void setTurno(String turno) {
        ClassCabecalho.turno = turno;
    }

    public static String getLinha() {
        return linha;
    }

    public static void setLinha(String linha) {
        ClassCabecalho.linha = linha;
    }

    public static String getProduto() {
        return produto;
    }

    public static void setProduto(String produto) {
        ClassCabecalho.produto = produto;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ClassCabecalho.id = id;
    }

    public static String getCliente() {
        return cliente;
    }

    public static void setCliente(String cliente) {
        ClassCabecalho.cliente = cliente;
    }

    public static String getQtdeLote() {
        return qtdeLote;
    }

    public static void setQtdeLote(String qtdeLote) {
        ClassCabecalho.qtdeLote = qtdeLote;
    }

    public static String getQtde() {
        return qtde;
    }

    public static void setQtde(String qtde) {
        ClassCabecalho.qtde = qtde;
    }
}
