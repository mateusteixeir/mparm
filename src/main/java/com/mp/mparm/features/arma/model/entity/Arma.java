package com.mp.mparm.features.arma.model.entity;

import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "ARMA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "MODELO", nullable = false, length = 100)
    private String modelo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CALIBRE_ID", nullable = false)
    private Calibre calibre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "FABRICANTE_ID", nullable = false)
    private Fabricante fabricante;

    @NotBlank
    @Column(name = "NUMERO_SERIE", nullable = false, unique = true)
    private String numeroSerie;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;
}
