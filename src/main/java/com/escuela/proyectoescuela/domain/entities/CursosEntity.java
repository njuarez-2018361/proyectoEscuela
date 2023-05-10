package com.escuela.proyectoescuela.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import org.apache.xerces.impl.xs.models.CMBuilder;

@Entity(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Data
CMBuilder
public class CursosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_curso;
    @Column(length = 60)
    private String titulo;
    @Column(length = 100)
    private String subtitulo;
    private String descripcion;
    private String imagen;
    private String video;
    private float horas_video;
    private int cantidad_recursos;
    private BigDecimal precio;

    @ManyToOne // muchos cursos pueden tener una categoria
    @JoinColumn(name = "curso_id") //
    private CategoriasEntity categorias;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructoresEnti instructores;

    @OneToOne
    @JoinColumn(name = "nivel_id")
    private NivelesEnti niveles;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cursos"
    )
    private Set<Comentarios_curso_Entity> comentarios_curso;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cursos"
    )
    private Set<InscripcionesEntity> inscripciones;
}
