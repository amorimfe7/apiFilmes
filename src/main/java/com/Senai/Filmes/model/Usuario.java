package com.Senai.Filmes.model;

import com.Senai.Filmes.model.ENUMS.Cargo;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuario")
//@Entity diz p/ o programa que não é uma classe normal, e sim, uma classe que representa uma entidade no banco de dados! Preciso colocar, se não é classe normal
@Data //cria estrutura (métodos) da minha classe (construtor, get's e set's, toString)
@NoArgsConstructor //cria construtor vázio p/ acesso


public class Usuario {

    @Id //definindo que é uma tabela de ID, ou seja, a nossa PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.UUID) //“Gere automaticamente um ID do tipo UUID”
    private UUID id;

    @NotBlank(message = "O campo 'nome' nao pode ser vazio")
    private String nome;

    @NotBlank(message = "O campo 'email' nao pode vazio")
    private String email;

    @NotBlank(message = "O campo 'senha' nao pode ser vazio")
    private String senha;

    @NotNull(message = "O cargo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @CreationTimestamp
    private LocalDateTime criadoEm;

}
