package com.qualidade.qapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notedod_table")
public class Dod {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String cliente;
    private final String str_dod;
    private final String turno;
    private final String gaveta;
    private final String cod_error;
    private final int quant;
    private final String date;
    private final String hora;
    private final String auditor;

    public Dod(String auditor, String cliente, String str_dod, String turno, String gaveta, String cod_error, int quant, String date, String hora) {
        this.auditor = auditor;
        this.cliente = cliente;
        this.str_dod = str_dod;
        this.turno = turno;
        this.gaveta = gaveta;
        this.cod_error = cod_error;
        this.quant = quant;
        this.date = date;
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getCliente() {
        return cliente;
    }
    public String getStr_dod() {
        return str_dod;
    }
    public String getTurno() {
        return turno;
    }
    public String getGaveta() {
        return gaveta;
    }
    public String getCod_error() {
        return cod_error;
    }
    public int getQuant() {
        return quant;
    }
    public String getHora() { return hora; }
    public String getDate() { return date; }
    public String getAuditor() { return auditor; }
}
