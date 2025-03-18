package com.mp.mparm.features.historicoMovimentacao.model.entity;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.arma.model.entity.Arma;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "HISTORICO_MOVIMENTACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "AGENTE_ID", nullable = false)
    private Agente agente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ARMA_ID", nullable = false)
    private Arma arma;

    @NotNull
    @Column(name = "DATA_MOVIMENTACAO", nullable = false)
    private LocalDateTime dataMovimentacao;

    @NotBlank
    @Column(name = "TIPO_MOVIMENTACAO", nullable = false, length = 50)
    private String tipoMovimentacao; // "RESERVA", "DEVOLUÇÃO", "TRANSFERÊNCIA"

    @Column(name = "OBSERVACAO")
    private String observacao;
}
