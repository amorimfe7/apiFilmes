package com.Senai.Filmes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name="reserva_assento")
public class ReservaAssento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //ReservaAssento é uma tabela intermediaria (N:N), então, temos 2 fk's (reserva_id) e (assento_id)
    //ent, se deixarmos sem o @JsonIgnore, ele vai ficar buscando nas 2 tabelas
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reserva_id") //vou pegar a coluna 'id'
    private Reserva reserva; //da coluna Reserva

    @ManyToOne
    @JoinColumn(name = "assento_id")
    private Assento assento;

    //por a tabela ser intermediaria na teoria temos 2 tabelas conectadas ('Reserva' e 'Assento')
    //mas precisamos puxar apenas de 1 dessas tabela com @JsonIgnore
    //no caso estamos puxando de 'Reserva'
}