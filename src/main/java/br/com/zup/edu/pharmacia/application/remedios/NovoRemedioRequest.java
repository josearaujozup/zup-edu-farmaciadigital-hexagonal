package br.com.zup.edu.pharmacia.application.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;
import br.com.zup.edu.pharmacia.domain.remedios.DadosRemedio;
import br.com.zup.edu.pharmacia.domain.remedios.Remedio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class NovoRemedioRequest implements DadosRemedio {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private Long farmaceuticaId;

    @Positive
    @NotNull
    private Long categoriaId;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;

    public NovoRemedioRequest(){

    }

    public NovoRemedioRequest(String nome, Long farmaceuticaId, Long categoriaId, LocalDate dataFabricacao, LocalDate dataValidade) {
        this.nome = nome;
        this.farmaceuticaId = farmaceuticaId;
        this.categoriaId = categoriaId;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public Long getFarmaceuticaId() {
        return farmaceuticaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    @Override
    public Remedio toModel() {

        return new Remedio(nome, dataFabricacao, dataValidade, new Farmaceutica(farmaceuticaId),
                new Categoria(categoriaId));
    }
}
