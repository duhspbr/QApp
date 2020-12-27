package com.qualidade.qapp.psc_bancario;

import java.io.Serializable;

public class ListaItens implements Serializable {
    private String item;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setItem(String item) {this.item = item; }

    public String getItem() { return item; }

    public ListaItens(String item, String status) {
        this.item = item;
        this.status = status;
    }
}
