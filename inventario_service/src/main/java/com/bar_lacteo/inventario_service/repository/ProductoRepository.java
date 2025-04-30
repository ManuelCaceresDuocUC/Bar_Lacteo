package com.bar_lacteo.inventario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario_service.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
