package br.espm.cambio;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    //MOEDA
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

    @DeleteMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public void delete(@PathVariable String id){
        moedaService.delete(id);
    }

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/cotacao")
    public List<Cotacao> ListCotacao(){
        return cotacaoService.listaAll();
    }

    @GetMapping("/cotacao/{simbolo:[A-Z]{3,}}")
    public List<Cotacao> findCotacaoBySimbolo(@PathVariable String simbolo) {
        List<Cotacao> cs = cotacaoService.findBySimbolo(simbolo);
        cs.forEach(c -> c.setId(null));
        return cs;
    }

    @PostMapping("/cotacao/{simbolo}/{ano}/{mes}/{dia}")
    public void save(@PathVariable String simbolo, @PathVariable String ano, @PathVariable String mes, @PathVariable String dia, @RequestBody Cotacao cotacao){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String data = ano + "-" + mes + "-" + dia;
       
        Date dt;
        try {
            Moeda moeda = moedaService.findBySimbolo(simbolo);
            dt = formatter.parse(data);
            UUID idMoeda = moeda.getId();
            cotacao.setData(dt);
            cotacao.setIdMoeda(idMoeda);
            cotacaoService.createCotacao(cotacao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
