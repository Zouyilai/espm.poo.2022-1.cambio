package br.espm.cambio;

public class Moeda {
    
    private String nome;
    private String simbolo;

    public Moeda(){

    }

    public Moeda(String nome, String simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
