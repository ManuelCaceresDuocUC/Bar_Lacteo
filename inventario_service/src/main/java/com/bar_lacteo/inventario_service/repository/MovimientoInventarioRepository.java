package com.bar_lacteo.inventario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario_service.model.MovimientoInventario;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Long> {
}