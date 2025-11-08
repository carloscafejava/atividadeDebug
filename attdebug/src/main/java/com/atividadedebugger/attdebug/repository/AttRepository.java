package com.atividadedebugger.attdebug.repository;

import com.atividadedebugger.attdebug.model.AttModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttRepository extends JpaRepository<AttModel, Integer> {
    // JpaRepository já fornece métodos padrão como:
    // save(), findById(), findAll(), delete(), etc.
}