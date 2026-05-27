package com.Senai.Filmes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name="sala")
@Entity

public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O 'nome' da sala nao pode ser vazio")
    private String nome;

    @Min(value = 1L, message = "A sala deve ter pelo menos 1 assento")
    private Integer totalAssentos;

    //orphanRemoval = sala é o pai, assentos são os filhos, e se eu remover pai remove tb filhos
    @OneToMany(mappedBy = "sala",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assento> listaAssentos = new ArrayList<>();


}
