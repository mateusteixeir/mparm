package com.mp.mparm.features.estoque.model.entity;

import com.mp.mparm.features.modeloArma.model.entity.ModeloArma;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "ESTOQUE_ARMA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MODELO_ARMA_ID", referencedColumnName = "ID", nullable = false)
    private ModeloArma modeloArma;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDate deletedAt;
}
