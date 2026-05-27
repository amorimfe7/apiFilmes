package com.Senai.Filmes.model;

import com.Senai.Filmes.model.ENUMS.StatusReserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "reservas")
@Entity
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    @NotBlank(message = "O campo 'status' nao pode ser vazio")
    private StatusReserva status;

    //CONT
//    @ManyToOne
//    @JoinColumn(name = "sessao_id")
//    private Sessao sessao;
}
