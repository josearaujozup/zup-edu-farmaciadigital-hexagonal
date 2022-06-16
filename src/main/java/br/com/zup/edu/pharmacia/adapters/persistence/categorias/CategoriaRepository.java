package br.com.zup.edu.pharmacia.adapters.persistence.categorias;

import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
