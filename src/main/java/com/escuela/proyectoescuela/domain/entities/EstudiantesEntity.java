package com.escuela.proyectoescuela.domain.entities;

import com.escuela.proyectoescuela.util.Genero;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EstudiantesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_estudiante;
    @Column(length = 120)
    private String nombre;
    @Column(length = 120)
    private String apellido;
    @Column(length = 120)
    private int email;
    @Column(length = 11)
    private int telefono;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String direccion;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "estudiantes"
    )
    private Set<InscripcionesEntity> inscripciones;
}
