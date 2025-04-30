package com.bar_lacteo.inventario_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario_service.model.Producto;
import com.bar_lacteo.inventario_service.repository.ProductoRepository;
import com.bar_lacteo.inventario_service.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
private final ProductoRepository productoRepository;

public ProductoController(ProductoService productoService, ProductoRepository productoRepository) {
    this.productoService = productoService;
    this.productoRepository = productoRepository;
}

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
    @GetMapping("/stock-bajo")
public List<Producto> productosConStockBajo() {
    return productoRepository.findAll()
            .stream()
            .filter(p -> p.getStockActual() < p.getStockMinimo())
            .collect(Collectors.toList());
}
}
