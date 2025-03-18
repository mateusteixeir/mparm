package com.mp.mparm.features.reserva.model.entity;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.arma.model.entity.Arma;
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
@Table(name = "RESERVA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

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
    @Column(name = "DATA_RESERVA", nullable = false)
    private LocalDate dataReserva;

    @Column(name = "DATA_DEVOLUCAO")
    private LocalDate dataDevolucao;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status; // Pode ser "RESERVADA", "DEVOLVIDA", "ATRASADA"

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;
}
