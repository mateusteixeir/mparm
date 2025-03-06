package com.mp.mparm.features.modeloArma.model.entity;


import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.estoque.model.entity.Estoque;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "MODELO_ARMA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ModeloArma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Size(max = 100)
    @Column(name = "NOME", nullable = false,  length = 100, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "CALIBRE_ID", referencedColumnName = "ID", nullable = false)
    private Calibre calibre;

    @ManyToMany
    @JoinTable(
            name = "MODELO_ARMA_FABRICANTE",
            joinColumns = @JoinColumn(name = "MODELO_ARMA_ID"),
            inverseJoinColumns = @JoinColumn(name = "FABRICANTE_ID")
    )
    private Set<Fabricante> fabricantes;

    @OneToOne(mappedBy = "modeloArma", cascade = CascadeType.ALL)
    private Estoque estoque;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDate deletedAt;
}
