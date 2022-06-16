package br.com.zup.edu.pharmacia.application.farmaceuticas;

import br.com.zup.edu.pharmacia.domain.farmaceuticas.DadosFarmaceutica;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class NovaFarmaceuticaRequest implements DadosFarmaceutica {

    @NotBlank
    private String nome;

    @NotBlank
    @CNPJ
    private String documento;

    @Email
    @NotBlank
    private String emailDeContato;

    @NotBlank
    private String telefonePrincipal;

    @JsonCreator(mode = PROPERTIES)
    public NovaFarmaceuticaRequest(String nome,
                                   String documento,
                                   String emailDeContato,
                                   String telefonePrincipal) {
        this.nome = nome;
        this.documento = documento;
        this.emailDeContato = emailDeContato;
        this.telefonePrincipal = telefonePrincipal;
    }


    @Override
    public Farmaceutica toModel() {
        return new Farmaceutica(nome, documento, emailDeContato, telefonePrincipal);
    }
}
