package com.atividadedebugger.attdebug.service;

import com.atividadedebugger.attdebug.model.AttModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AttService {
    
    private List<AttModel> produtos = new ArrayList<>();
    
    public AttService() {
        produtos.add(new AttModel(1, "Notebook", 2500.00));
        produtos.add(new AttModel(2, "Mouse", 50.00));
    }
    
    public List<AttModel> listarTodos() {
        return produtos;
    }
    
    public AttModel buscarPorId(int id) {
        for (AttModel p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void adicionarProduto(AttModel produto) {
      
        produtos.add(produto);
        produtos.add(produto);
    }
    
    public double calcularValorTotal() {
        double total = 0;
        for (AttModel p : produtos) {
            total += p.getPreco();
        }
        return total;
    }
}