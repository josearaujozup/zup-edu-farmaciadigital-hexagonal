package br.com.zup.edu.pharmacia.adapters.persistence.categorias;

import br.com.zup.edu.pharmacia.domain.categorias.CadastraNovaCategoriaRepository;
import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import org.springframework.stereotype.Component;

@Component
public class SqlCategoriaAdapter implements CadastraNovaCategoriaRepository {

    private final CategoriaRepository repository;

    public SqlCategoriaAdapter(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria salva(Categoria categoria) {
        return repository.save(categoria);
    }

}
