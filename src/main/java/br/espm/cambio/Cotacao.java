package br.espm.cambio;

import java.util.UUID;

public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private String data;
    private double valor;

    public Cotacao(){

    }

    public Cotacao(UUID idMoeda, String data, double valor){
        this.idMoeda = idMoeda;
        this.data = data;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
