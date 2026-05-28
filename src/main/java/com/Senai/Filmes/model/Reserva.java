package com.Senai.Filmes.model;

import com.Senai.Filmes.model.ENUMS.StatusReserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    //como se fosse
    //reserva FOREIGN KEY usuario(id) REFERENCES reserva(usuario_id)
    //em 'reserva' vá na tabela 'usuario' na coluna 'id' e na tabela 'reserva' crie um coluna
    //chamada 'usuario_id' que vai ser um espelho da coluna 'id' em 'usuario'
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id") //vou pegar a coluna "id" ->..
    private Usuario usuario; //da tabela Usuario

    @ManyToOne
    @JoinColumn(name = "id")
    private Sessao sessao;

    @NotBlank(message = "O campo 'status' nao pode ser vazio")
    private StatusReserva status;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    //quando temos relação de 1:N o '1', é sinalizado no nosso mappedBy = nome da coluna
    //para 1 reserva podemos pegar N assentos
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<ReservaAssento> listaAssentos = new ArrayList<>();

}
