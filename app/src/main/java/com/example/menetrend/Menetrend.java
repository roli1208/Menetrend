package com.example.menetrend;


public class Menetrend {
    private String id;
    private String indVaros;
    private String indIdo;
    private String erkVaros;
    private String erkIdo;

    public Menetrend(String indVaros, String indIdo, String erkVaros, String erkIdo) {
        this.indVaros = indVaros;
        this.indIdo = indIdo;
        this.erkVaros = erkVaros;
        this.erkIdo = erkIdo;
    }

    public String getIndVaros() {
        return indVaros;
    }

    public String getIndIdo() {
        return indIdo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErkVaros() {
        return erkVaros;
    }

    public String getErkIdo() {
        return erkIdo;
    }
}
