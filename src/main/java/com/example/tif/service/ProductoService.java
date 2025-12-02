package com.example.tif.service;

import com.example.tif.model.Producto;
import com.example.tif.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para operaciones de negocio sobre Producto.
 * Contiene reglas: precio no negativo y nombre único.
 */
@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Crea un producto aplicando reglas de negocio.
     */
    public Producto createProducto(Producto p) {
        if (p.getPrice() < 0) throw new IllegalArgumentException("Price must be >= 0");
        List<Producto> sameName = productoRepository.findByNameContaining(p.getName());
        for (Producto sp : sameName) {
            if (sp.getName().equalsIgnoreCase(p.getName())) throw new IllegalArgumentException("Product name must be unique");
        }
        return productoRepository.save(p);
    }

    public List<Producto> listAll() { return productoRepository.findAll(); }
    public Producto getById(Long id) { return productoRepository.findById(id).orElse(null); }
    public Producto update(Producto p) { return productoRepository.save(p); }
    public void delete(Long id) { productoRepository.deleteById(id); }
}
