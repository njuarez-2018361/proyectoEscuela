package com.escuela.proyectoescuela.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.io.Serializable;
import java.util.Set;

;

@Entity(name = "niveles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NivelesEnti implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_nivel;
    @Column(length = 45)
    private String tipo;


    @OneToOne(mappedBy = "niveles")
    private CursosEnti cursos;
}
