package com.bar_lacteo.inventario_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario_service.model.OrdenCompra;
import com.bar_lacteo.inventario_service.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepository repository;

    public OrdenCompraService(OrdenCompraRepository repository) {
        this.repository = repository;
    }

    public List<OrdenCompra> listar() {
        return repository.findAll();
    }

    public OrdenCompra guardar(OrdenCompra orden) {
        return repository.save(orden);
    }

    public OrdenCompra buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}