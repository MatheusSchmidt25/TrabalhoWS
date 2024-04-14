package br.unipar.programacaoweb.trabalhows.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String titulo;

    @Column(length = 20)
    private String arquivo_pdf;

    @Column(length = 120)
    private String autor;

    @Column(length = 10)
    private String clasificacao_etaria;

    @Column(length = 120)
    private Integer estante_id;

    @Column(length = 20)
    private Boolean estou_lendo;
}
