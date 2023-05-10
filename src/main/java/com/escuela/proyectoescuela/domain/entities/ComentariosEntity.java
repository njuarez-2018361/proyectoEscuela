package com.escuela.proyectoescuela.domain.entities;


import com.escuela.proyectoescuela.util.Puntaje;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ComentariosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_comentario;
    @Column(length = 60)
    private String titulo_comentario;
    private String texto_comentario;
    @Enumerated(EnumType.STRING)
    private Puntaje puntaje;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "comentarios"
    )
    private Set<Comentarios_curso_Entity> comentarios_curso;

}
