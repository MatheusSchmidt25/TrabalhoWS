package br.unipar.programacaoweb.trabalhows.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 60)
    private String descricao;

    @Column(length = 20)
    private Integer usuario_id;
}
