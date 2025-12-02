package com.example.tif.controller;

import com.example.tif.model.Cliente;
import com.example.tif.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones CRUD sobre Cliente.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) { this.clienteService = clienteService; }

    /**
     * Listar todos los clientes.
     */
    @GetMapping
    public List<Cliente> all() { return clienteService.listAll(); }

    /**
     * Obtener un cliente por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id) {
        Cliente c = clienteService.getById(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    /**
     * Crear un nuevo cliente.
     */
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente c) { return ResponseEntity.ok(clienteService.create(c)); }

    /**
     * Actualizar un cliente existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente c) {
        Cliente existing = clienteService.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        c.setId(id);
        return ResponseEntity.ok(clienteService.update(c));
    }

    /**
     * Eliminar un cliente por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
