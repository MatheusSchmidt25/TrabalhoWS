package br.unipar.programacaoweb.trabalhows.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 60)
    private String nome;

    @Column(length = 20)
    private Integer idade;

}
