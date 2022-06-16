package br.com.zup.edu.pharmacia.domain.categorias;

import org.springframework.stereotype.Service;

@Service
public class CadastraNovaCategoria {

    private final CadastraNovaCategoriaRepository repository;

    public CadastraNovaCategoria(CadastraNovaCategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria cadastraNovaCategoria(String nome) {

        return repository.salva(new Categoria(nome));
    }
}
