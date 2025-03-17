package com.mp.mparm.features.agente.usecase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AgenteCadDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O sobrenome é obrigatório")
        String sobrenome,

        @NotBlank(message = "O CPF é obrigatório")
        String cpf,

        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate dataNascimento,

        @NotBlank(message = "O email é obrigatório")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone
) {}
