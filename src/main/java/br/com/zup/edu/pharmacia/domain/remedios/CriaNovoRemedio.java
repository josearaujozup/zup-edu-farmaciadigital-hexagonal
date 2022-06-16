package br.com.zup.edu.pharmacia.domain.remedios;

import br.com.zup.edu.pharmacia.application.remedios.NovoRemedioRequest;
import org.springframework.stereotype.Service;

@Service
public class CriaNovoRemedio {

    private final CadastraNovoRemedioRepository repository;

    public CriaNovoRemedio(CadastraNovoRemedioRepository repository) {
        this.repository = repository;
    }

    public Remedio cadastraNovoRemedio(DadosRemedio dados) {
        var remedio = dados.toModel();

        return repository.salva(remedio);
    }
}
