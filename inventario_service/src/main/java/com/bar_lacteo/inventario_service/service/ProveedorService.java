package com.bar_lacteo.inventario_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario_service.model.Proveedor;
import com.bar_lacteo.inventario_service.repository.ProveedorRepository;

@Service
public class ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    public List<Proveedor> listar() {
        return repository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}