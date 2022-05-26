package br.espm.cambio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //promover um serviço rest
public class CambioResource {

    //com o banco não há necessidade de criar essa lista
    //private List<Moeda> moedas = new ArrayList<>();
    @Autowired
    private MoedaService moedaService;
    
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello ESPM";
    }

    @GetMapping("/moeda")
    public List<Moeda> ListMoeda(){
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo:[A-Z]{3,}}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public Moeda findMoedaById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return moedaService.findBy(uuid);
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda){
        moedaService.create(moeda);
        //moedas.add(moeda);
    }
}
