package com.example.tif.controller;

import com.example.tif.model.Categoria;
import com.example.tif.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones CRUD sobre Categoria.
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    /**
     * Listar todas las categorías.
     */
    @GetMapping
    public List<Categoria> all() { return categoriaService.listAll(); }

    /**
     * Obtener una categoría por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        Categoria c = categoriaService.getById(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    /**
     * Crear una nueva categoría.
     */
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria c) { return ResponseEntity.ok(categoriaService.create(c)); }

    /**
     * Actualizar una categoría existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria c) {
        Categoria existing = categoriaService.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        c.setId(id);
        return ResponseEntity.ok(categoriaService.update(c));
    }

    /**
     * Eliminar una categoría por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
