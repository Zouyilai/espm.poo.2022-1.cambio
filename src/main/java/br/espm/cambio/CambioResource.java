package br.espm.cambio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

        /*moedas.add(new Moeda("Real", "BRL"));
        moedas.add(new Moeda("Rublo", "RUB"));
        moedas.add(new Moeda("Dólar", "USD"));
        moedas.add(new Moeda("Euro", "EUR"));
        moedas.add(new Moeda("Yuan", "CHN"));*/

        return moedaService.listaAll();
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda){
        moedaService.create(moeda);
        //moedas.add(moeda);
    }
}
