package com.example.tif.repository;

import com.example.tif.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Categoria.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByName(String name);
}
