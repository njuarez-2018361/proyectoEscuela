package com.escuela.proyectoescuela.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity(name = "comentarios_curso")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comentarios_curso_Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id;

    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private ComentariosEntity comentarios;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursosEnti cursos;
}

