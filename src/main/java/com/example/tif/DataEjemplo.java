package com.example.tif;

import com.example.tif.model.*;
import com.example.tif.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Carga datos de ejemplo al iniciar la aplicación.
 */
@Configuration
public class DataEjemplo {
    @Bean
    CommandLineRunner initData(CategoriaRepository categoriaRepo, ProductoRepository productoRepo, ClienteRepository clienteRepo) {
        return args -> {
            Categoria cat1 = categoriaRepo.save(new Categoria("Electrónica"));
            Categoria cat2 = categoriaRepo.save(new Categoria("Libros"));
            Categoria cat3 = categoriaRepo.save(new Categoria("Hogar"));
            Producto p1 = new Producto();
            p1.setName("Laptop"); p1.setPrice(1200); p1.setStock(5); p1.setCategoria(cat1);
            productoRepo.save(p1);
            Producto p2 = new Producto();
            p2.setName("Libro Java"); p2.setPrice(40); p2.setStock(20); p2.setCategoria(cat2);
            productoRepo.save(p2);
            Producto p3 = new Producto();
            p3.setName("Aspiradora"); p3.setPrice(300); p3.setStock(10); p3.setCategoria(cat3);
            productoRepo.save(p3);
            Producto p4 = new Producto();
            p4.setName("Smartphone"); p4.setPrice(800); p4.setStock(8); p4.setCategoria(cat1);
            productoRepo.save(p4);
            Cliente c1 = new Cliente();
            c1.setName("Ana");
            c1.setEmail("ana@mail.com");
            clienteRepo.save(c1);
            Cliente c2 = new Cliente();
            c2.setName("Luis");
            c2.setEmail("luis@mail.com");
            clienteRepo.save(c2);
            Cliente c3 = new Cliente();
            c3.setName("Marta");
            c3.setEmail("marta@mail.com");
            clienteRepo.save(c3);
        };
    }
}