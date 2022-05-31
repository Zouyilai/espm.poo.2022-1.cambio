package br.espm.cambio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private Date data;
    private BigDecimal valor;

    public Cotacao(){

    }

    public Cotacao(UUID idMoeda, Date data, BigDecimal valor){
        this.idMoeda = idMoeda;
        this.data = data;
        this.valor = valor;
    }

    public Cotacao(BigDecimal valor){
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
