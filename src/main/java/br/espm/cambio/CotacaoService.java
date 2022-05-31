package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository cotacaoRepository;
    //createCotacao
    
    public List<Cotacao> listaAll() {
        return StreamSupport
            //transforma de iterável para lista
            .stream(cotacaoRepository.findAll().spliterator(), false) //stream -> gera uma lista
            .collect(Collectors.toList()) 
            //transforma de model para objeto Moeda
            .stream().map(CotacaoModel::to) //tranforma em elementos para possibilitar a interação
            .collect(Collectors.toList());
    }

    public Cotacao createCotacao(Cotacao vo){
        vo.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(vo)).to();
    }

    public List<Cotacao> findBySimbolo(String simbolo){
        return StreamSupport
            .stream(cotacaoRepository.findBySimbolo(simbolo).spliterator(), false)
            .collect(Collectors.toList())
            .stream().map(CotacaoModel::to)
            .collect(Collectors.toList());
    }
}
