package com.bar_lacteo.inventario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario_service.model.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
}