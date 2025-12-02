package com.example.tif.controller;

import com.example.tif.service.ProductoService;
import com.example.tif.service.CategoriaService;
import com.example.tif.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para vistas Thymeleaf de productos, categorías y clientes.
 */
@Controller
public class WebController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final ClienteService clienteService;

    public WebController(ProductoService productoService, CategoriaService categoriaService, ClienteService clienteService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
        this.clienteService = clienteService;
    }

    /**
     * Vista de productos (Thymeleaf).
     */
    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoService.listAll());
        return "productos";
    }

    /**
     * Vista de categorías (Thymeleaf).
     */
    @GetMapping("/categorias")
    public String categorias(Model model) {
        model.addAttribute("categorias", categoriaService.listAll());
        return "categorias";
    }

    /**
     * Vista de clientes (Thymeleaf).
     */
    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listAll());
        return "clientes";
    }
}
