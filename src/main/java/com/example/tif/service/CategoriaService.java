package com.example.tif.service;

import com.example.tif.model.Categoria;
import com.example.tif.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar operaciones CRUD sobre Categoria.
 */
@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(Categoria c) { return categoriaRepository.save(c); }
    public List<Categoria> listAll() { return categoriaRepository.findAll(); }
    public Categoria getById(Long id) { return categoriaRepository.findById(id).orElse(null); }
    public Categoria update(Categoria c) { return categoriaRepository.save(c); }
    public void delete(Long id) { categoriaRepository.deleteById(id); }
}
