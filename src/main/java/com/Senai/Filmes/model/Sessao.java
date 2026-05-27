package com.Senai.Filmes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "sessao")
@Entity
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
