package com.bar_lacteo.inventario_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // entrada, salida, ajuste, merma

    private int cantidad;

    private String motivo; // motivo de la operación (opcional)

    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    private Producto producto;
}