package com.atividadedebugger.attdebug.controller;

import com.atividadedebugger.attdebug.model.AttModel;
import com.atividadedebugger.attdebug.service.AttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class AttController {
    
    @Autowired
    private AttService attService;
    
    @GetMapping
    public ResponseEntity<List<AttModel>> listarTodos() {
        List<AttModel> produtos = attService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AttModel> buscarPorId(@PathVariable int id) {
        AttModel produto = attService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<AttModel> adicionarProduto(@RequestBody AttModel produto) {
        AttModel produtoSalvo = attService.adicionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AttModel> atualizarProduto(@PathVariable int id, @RequestBody AttModel produto) {
        AttModel produtoAtualizado = attService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int id) {
        AttModel produto = attService.buscarPorId(id);
        if (produto != null) {
            attService.deletarProduto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/total")
    public ResponseEntity<Double> calcularTotal() {
        double total = attService.calcularValorTotal();
        return ResponseEntity.ok(total);
    }
}