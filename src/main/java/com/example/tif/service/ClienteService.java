package com.example.tif.service;

import com.example.tif.model.Cliente;
import com.example.tif.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para operaciones CRUD sobre Cliente.
 */
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente create(Cliente c) { return clienteRepository.save(c); }
    public List<Cliente> listAll() { return clienteRepository.findAll(); }
    public Cliente getById(Long id) { return clienteRepository.findById(id).orElse(null); }
    public Cliente update(Cliente c) { return clienteRepository.save(c); }
    public void delete(Long id) { clienteRepository.deleteById(id); }
}
