package com.qualidade.qapp.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notepsc_table")
public class Psc {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String turno;
    private final String linha;
    private final String cliente;
    private final String prod_audit;
    private final String qtde_lote;
    private final String id_ordem;
    private final String qtde_amostra;
    private final String item;
    private final String status;
    private final String hora;
    private final String date;
    private final String auditor;


    public Psc(String auditor, String turno, String linha, String cliente, String prod_audit, String id_ordem, String qtde_lote, String qtde_amostra, String item, String status, String date, String hora) {
        this.auditor = auditor;
        this.cliente = cliente;
        this.id_ordem = id_ordem;
        this.turno = turno;
        this.linha = linha;
        this.prod_audit = prod_audit;
        this.qtde_amostra = qtde_amostra;
        this.qtde_lote = qtde_lote;
        this.item = item;
        this.status = status;
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

    public String getId_ordem() {
        return id_ordem;
    }

    public String getTurno() {
        return turno;
    }

    public String getLinha() {
        return linha;
    }

    public String getProd_audit() {
        return prod_audit;
    }

    public String getQtde_amostra() {
        return qtde_amostra;
    }

    public String getItem() { return item; }

    public String getQtde_lote() { return qtde_lote; }

    public String getStatus() { return status; }

    public String getDate() { return date; }

    public String getHora() { return hora; }

    public String getAuditor() { return auditor; }
}
