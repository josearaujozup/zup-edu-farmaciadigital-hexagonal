package br.com.zup.edu.pharmacia.domain.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Remedio {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @ManyToOne(optional = false)
    private Farmaceutica farmaceutica;

    @ManyToOne(optional = false)
    private Categoria categoria;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public Remedio() {
    }

    public Remedio(String nome, LocalDate dataFabricacao, LocalDate dataValidade, Farmaceutica farmaceutica, Categoria categoria) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.farmaceutica = farmaceutica;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }
}
