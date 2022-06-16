package br.com.zup.edu.pharmacia.domain.farmaceuticas;

import org.springframework.stereotype.Service;

@Service
public class CriaNovaFarmaceutica {

    private final CadastraNovaFarmaceuticaRepository repository;

    public CriaNovaFarmaceutica(CadastraNovaFarmaceuticaRepository repository) {
        this.repository = repository;
    }

    public Farmaceutica cadastraNovaFarmceutica(DadosFarmaceutica dados) {

        var farmaceutica = dados.toModel();


        return repository.salva(farmaceutica);
    }
}
