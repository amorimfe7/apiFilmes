package com.Senai.Filmes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "assento")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @NotBlank(message = "O campo fileira é obrigatório")
    private String fileira;

    @NotNull
    private int numero;

}
