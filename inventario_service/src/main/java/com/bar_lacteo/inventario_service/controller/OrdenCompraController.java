package com.bar_lacteo.inventario_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario_service.model.OrdenCompra;
import com.bar_lacteo.inventario_service.service.OrdenCompraService;

@RestController
@RequestMapping("/ordenes")
public class OrdenCompraController {

    private final OrdenCompraService service;

    public OrdenCompraController(OrdenCompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrdenCompra> listar() {
        return service.listar();
    }

    @PostMapping
    public OrdenCompra guardar(@RequestBody OrdenCompra orden) {
        return service.guardar(orden);
    }

    @GetMapping("/{id}")
    public OrdenCompra buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
