package com.atividadedebugger.attdebug.controller;

import com.atividadedebugger.attdebug.model.AttModel;
import com.atividadedebugger.attdebug.service.AttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class AttController {
    
   @Autowired
    private AttService produtoService;
    
    @GetMapping
    public List<AttModel> listarTodos() {
        return produtoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public AttModel buscarPorId(@PathVariable int id) {
        return produtoService.buscarPorId(id);
    }
    
    @PostMapping
    public void adicionarProduto(@RequestBody AttModel produto) {
        produtoService.adicionarProduto(produto);
    }
    
    @GetMapping("/total")
    public double calcularTotal() {
        return produtoService.calcularValorTotal();
    }
}