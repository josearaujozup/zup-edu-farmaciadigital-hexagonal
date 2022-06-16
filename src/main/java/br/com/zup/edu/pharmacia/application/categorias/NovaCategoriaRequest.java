package br.com.zup.edu.pharmacia.application.categorias;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    @JsonCreator(mode = PROPERTIES)
    public NovaCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
