package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*Esse é o microserviço de moeda*/
@Component
public class MoedaService {

    @Autowired //procurar e instanciar
    private MoedaRepository moedaRepository; //comunicar com o banco de dados
    
    public List<Moeda> listaAll() {
        return StreamSupport
            //transforma de iterável para lista
            .stream(moedaRepository.findAll().spliterator(), false) //stream -> gera uma lista
            .collect(Collectors.toList()) 
            //transforma de model para objeto Moeda
            .stream().map(MoedaModel::to) //tranforma em elementos para possibilitar a interação
            .collect(Collectors.toList());
    }

    public Moeda create(Moeda vo){
        vo.setId(UUID.randomUUID());
        return moedaRepository.save(new MoedaModel(vo)).to();
    }

    public void delete(String id){
        moedaRepository.deleteById(id);
    }

    public Moeda findBySimbolo(String simbolo){
        return moedaRepository.findBySimbolo(simbolo)
                    .map(MoedaModel::to)
                    .orElse(null);
    }

    public Moeda findBy(UUID id) {
        return moedaRepository.findById(id.toString())
                    .map(MoedaModel::to)
                    .orElse(null);
    }

}
