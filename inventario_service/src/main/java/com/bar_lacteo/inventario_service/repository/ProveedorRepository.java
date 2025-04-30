package com.bar_lacteo.inventario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario_service.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}