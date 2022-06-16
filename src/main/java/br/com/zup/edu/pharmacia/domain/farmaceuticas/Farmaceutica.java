package br.com.zup.edu.pharmacia.domain.farmaceuticas;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Farmaceutica {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @CNPJ
    @Column(unique = true)
    private String documento;

    @NotBlank
    @Email
    @Column(unique = true)
    private String emailDeContato;

    @NotBlank
    private String telefonePrincipal;

    public Farmaceutica(String nome,
                        String documento,
                        String emailDeContato,
                        String telefonePrincipal) {

        this.nome = nome;
        this.documento = documento;
        this.emailDeContato = emailDeContato;
        this.telefonePrincipal = telefonePrincipal;
    }

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public Farmaceutica() { }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmaceutica that = (Farmaceutica) o;
        return documento.equals(that.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
