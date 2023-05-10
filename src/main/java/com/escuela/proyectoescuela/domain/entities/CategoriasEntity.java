package com.escuela.proyectoescuela.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoriasEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int id_categoria;
    @Column(length = 120)
    private String nombre_categoria;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "categorias"
    )
    private Set<CursosEnti> cursos;
}

