package com.atividadedebugger.attdebug.model;


public class AttModel {
    private int id;
    private String nome;
    private Double preco;
    
     public AttModel() {

    }

    public AttModel(int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    

    public void setPreco(String preco) {
        this.preco = Double.parseDouble(preco);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
