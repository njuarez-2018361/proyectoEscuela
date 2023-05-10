package com.escuela.proyectoescuela.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "instructores")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InstructoresEnti implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_instructores;
    @Column(length = 120)
    private String nombre;
    @Column(length = 120)
    private String apellido;
    @Column(length = 11)
    private int identificacion;
    @Column(length = 120)
    private String ciudad;
    @Column(length = 120)
    private String pais;
    private String direccion;
    @Column(length = 11)
    private int telefono;
    @Column(length = 100)
    private String correo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "instructores"
    )
    private Set<CursosEnti> cursos; //

}
