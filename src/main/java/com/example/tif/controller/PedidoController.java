package com.example.tif.controller;

import com.example.tif.model.Pedido;
import com.example.tif.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para crear pedidos (verifica stock y calcula total).
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) { this.pedidoService = pedidoService; }

    /**
     * Crear un nuevo pedido.
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido) {
        try { return ResponseEntity.ok(pedidoService.createPedido(pedido)); }
        catch (IllegalArgumentException ex) { return ResponseEntity.badRequest().body(ex.getMessage()); }
    }
}
