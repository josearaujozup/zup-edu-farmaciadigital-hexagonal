package br.com.zup.edu.pharmacia.domain.categorias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;


    /**
     * @deprecated para uso de frameworks
     */
    @Deprecated
    public Categoria() { }

    public Categoria(String nome) {
        this.nome = Objects.requireNonNull(nome, "nome nao pode ser nulo");
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return nome.equals(categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
