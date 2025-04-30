package com.bar_lacteo.inventario_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario_service.model.MovimientoInventario;
import com.bar_lacteo.inventario_service.service.MovimientoInventarioService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoInventarioController {

    private final MovimientoInventarioService service;

    public MovimientoInventarioController(MovimientoInventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovimientoInventario> listar() {
        return service.listar();
    }

    @PostMapping
    public MovimientoInventario guardar(@RequestBody MovimientoInventario movimiento) {
        return service.guardar(movimiento);
    }

    @GetMapping("/{id}")
    public MovimientoInventario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
