package com.bar_lacteo.inventario_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario_service.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
