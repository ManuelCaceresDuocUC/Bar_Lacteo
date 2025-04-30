package com.bar_lacteo.inventario_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private int stockActual;

    private int stockMinimo;

    private String unidadMedida; // ejemplo: litros, kilos, unidades

    private String ubicacion; // por ejemplo "Estante A2"

    @ManyToOne
    private Proveedor proveedor;
    @ManyToOne
    private Categoria categoria
    ;
}
