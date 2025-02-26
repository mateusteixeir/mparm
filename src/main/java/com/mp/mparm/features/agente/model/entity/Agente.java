package com.mp.mparm.features.agente.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "AGENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Column(name = "SOBRENOME", nullable = false, length = 100)
    private String sobrenome;

    @NotBlank
    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @NotBlank
    @Email
    @Column(name = "EMAIL", nullable = false, unique = true, length = 255)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 digitos")
    @Column(name = "TELEFONE", length = 20)
    private Integer telefone;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDate deletedAt;

}
