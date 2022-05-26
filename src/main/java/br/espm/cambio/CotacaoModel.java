package br.espm.cambio;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotacao")
public class CotacaoModel{

    @Id
    @Column(name = "id_cotacao")
    private String idCotacao;

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "dt_data")
    private String dtData;

    @Column(name = "vr_valor")
    private double vrValor;

    public CotacaoModel(){

    }

    public CotacaoModel(Cotacao cotacao){
        this.idCotacao = cotacao.getId().toString();
        this.idMoeda = cotacao.getIdMoeda().toString();
        this.dtData = cotacao.getData();
        this.vrValor = cotacao.getValor();
    }

    public Cotacao to() {
        Cotacao cotacao = new Cotacao();
        cotacao.setId(UUID.fromString(this.idCotacao));
        cotacao.setIdMoeda(UUID.fromString(this.idCotacao));
        cotacao.setData(this.dtData);
        cotacao.setValor(this.vrValor);
        return cotacao;
    }
}
