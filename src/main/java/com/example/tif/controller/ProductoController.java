package com.example.tif.controller;

import com.example.tif.model.Producto;
import com.example.tif.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones CRUD sobre Producto.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) { this.productoService = productoService; }

    /**
     * Listar todos los productos.
     */
    @GetMapping
    public List<Producto> all() { return productoService.listAll(); }

    /**
     * Obtener un producto por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Long id) {
        Producto p = productoService.getById(id);
        return p == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }

    /**
     * Crear un nuevo producto.
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto p) {
        try { return ResponseEntity.ok(productoService.createProducto(p)); }
        catch (IllegalArgumentException ex) { return ResponseEntity.badRequest().body(ex.getMessage()); }
    }

    /**
     * Actualizar un producto existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto p) {
        Producto existing = productoService.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        p.setId(id);
        return ResponseEntity.ok(productoService.update(p));
    }

    /**
     * Eliminar un producto por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
