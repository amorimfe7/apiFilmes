package com.Senai.Filmes.model;



import com.Senai.Filmes.model.ENUMS.GeneroFilme;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;


@Entity //@Entity diz p/ o programa que não é uma classe normal, e sim, uma classe que representa uma entidade no banco de dados! Preciso colocar, se não é classe normal
@Data //cria estrutura (métodos) da minha classe (construtor, get's e set's, toString)
@Table(name = "filme")
public class Filmes {

    @Id //definindo que é uma tabela de ID, ou seja, a nossa PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.UUID) //“Gere automaticamente um ID do tipo UUID”
    private UUID id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(columnDefinition = "TEXT") //String vai até 255 caracteres, utilizamos TEXT pois cabe mais caracteres e a descricao de um filme pode ser bem grande..
    private String descricao;
    private String urlPoster; //url da foto do catalago de

    @NotNull(message = "O campo Genero é obrigatório!")
    @Enumerated(EnumType.STRING)
    private GeneroFilme genero;

    @NotNull(message = "O campo Minutos é obrigatório!")
    @Min(value = 1, message = "A duração dever maior que 0")
    private Integer duracaoMinutos; //facilita int to String parse


}
