package com.example.tif.service;

import com.example.tif.model.Pedido;
import com.example.tif.model.Producto;
import com.example.tif.repository.PedidoRepository;
import com.example.tif.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para gestionar Pedidos: verifica stock y calcula total.
 */
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    /**
     * Crea un pedido: comprueba stock, descuenta y calcula el total.
     */
    @Transactional
    public Pedido createPedido(Pedido pedido) {
        Producto p = productoRepository.findById(pedido.getProducto().getId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        if (pedido.getQuantity() <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        if (p.getStock() < pedido.getQuantity()) throw new IllegalArgumentException("Not enough stock");
        p.setStock(p.getStock() - pedido.getQuantity());
        productoRepository.save(p);
        double total = p.getPrice() * pedido.getQuantity();
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
    }
}
