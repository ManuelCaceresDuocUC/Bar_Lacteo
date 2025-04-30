package com.bar_lacteo.inventario_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bar_lacteo.inventario_service.model.MovimientoInventario;
import com.bar_lacteo.inventario_service.model.Producto;
import com.bar_lacteo.inventario_service.repository.MovimientoInventarioRepository;
import com.bar_lacteo.inventario_service.repository.ProductoRepository;

@Service
public class MovimientoInventarioService {

    private final MovimientoInventarioRepository repository;
    private final ProductoRepository productoRepository;

    public MovimientoInventarioService(MovimientoInventarioRepository repository, ProductoRepository productoRepository) {
        this.repository = repository;
        this.productoRepository = productoRepository;
    }

    public List<MovimientoInventario> listar() {
        return repository.findAll();
    }

    public MovimientoInventario guardar(MovimientoInventario movimiento) {
        Producto producto = productoRepository.findById(movimiento.getProducto().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        int cantidad = movimiento.getCantidad();
        String tipo = movimiento.getTipo();

        switch (tipo.toLowerCase()) {
            case "entrada" -> producto.setStockActual(producto.getStockActual() + cantidad);
            case "salida" -> {
                if (producto.getStockActual() < cantidad) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuficiente para la salida");
                }
                producto.setStockActual(producto.getStockActual() - cantidad);
            }
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de movimiento no válido (solo 'entrada' o 'salida')");
        }

        productoRepository.save(producto);
        return repository.save(movimiento);
    }

    public MovimientoInventario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
