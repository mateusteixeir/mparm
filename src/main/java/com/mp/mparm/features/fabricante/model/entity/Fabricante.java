package com.mp.mparm.features.fabricante.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FABRICANTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;
}
