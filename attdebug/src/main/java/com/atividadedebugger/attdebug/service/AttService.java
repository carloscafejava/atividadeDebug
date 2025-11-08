package com.atividadedebugger.attdebug.service;

import com.atividadedebugger.attdebug.model.AttModel;
import com.atividadedebugger.attdebug.repository.AttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AttService {
    
    @Autowired
    private AttRepository attRepository;
    
    public List<AttModel> listarTodos() {
        return attRepository.findAll();
    }
    
    public AttModel buscarPorId(int id) {
        Optional<AttModel> produto = attRepository.findById(id);
        return produto.orElse(null);
    }
    
    public AttModel adicionarProduto(AttModel produto) {
        return attRepository.save(produto);
    }
    
    public AttModel atualizarProduto(int id, AttModel produtoAtualizado) {
        Optional<AttModel> produtoExistente = attRepository.findById(id);
        
        if (produtoExistente.isPresent()) {
            AttModel produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return attRepository.save(produto);
        }
        return null;
    }
    
    public void deletarProduto(int id) {
        attRepository.deleteById(id);
    }
    
    public double calcularValorTotal() {
        List<AttModel> produtos = attRepository.findAll();
        double total = 0;
        for (AttModel p : produtos) {
            total += p.getPreco();
        }
        return total;
    }
}