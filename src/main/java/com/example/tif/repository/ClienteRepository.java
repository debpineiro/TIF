package com.example.tif.repository;

import com.example.tif.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Cliente.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}
