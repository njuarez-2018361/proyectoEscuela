package com.escuela.proyectoescuela.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "inscripciones")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InscripcionesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id;
    private BigDecimal precio_pagado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private EstudiantesEntity estudiantes;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CursosEnti cursos;

}
