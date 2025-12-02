package com.example.tif.repository;

import com.example.tif.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la entidad Producto. Contiene query methods de ejemplo.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNameContaining(String name);
    List<Producto> findByCategoria_Name(String categoriaName);
}
