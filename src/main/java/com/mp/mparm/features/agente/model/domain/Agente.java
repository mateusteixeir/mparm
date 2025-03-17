package com.mp.mparm.features.agente.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Agente {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public Agente(Long id, String nome, String sobrenome, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public static Agente criarAgente(String nome, String sobrenome, String cpf, LocalDate dataNascimento, String email, String telefone){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Agente não encontrado");
        }

        return new Agente(null ,nome, sobrenome, cpf, dataNascimento,  email, telefone);
    }
}
