package com.atividadedebugger.attdebug.controller;

import com.atividadedebugger.attdebug.model.AttModel;
import com.atividadedebugger.attdebug.service.AttService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api/produtos")
public class AttController {
    
   
    private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable int id) {
        return produtoService.buscarPorId(id);
    }
    
    @PostMapping
    public void adicionarProduto(@RequestBody Produto produto) {
        produtoService.adicionarProduto(produto);
    }
    
    @GetMapping("/total")
    public double calcularTotal() {
        return produtoService.calcularValorTotal();
    }
}