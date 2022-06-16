package br.com.zup.edu.pharmacia.application.farmaceuticas;

import br.com.zup.edu.pharmacia.domain.farmaceuticas.CriaNovaFarmaceutica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/farmaceuticas")
public class CadastraFarmaceuticaController {

    private final CriaNovaFarmaceutica service;

    public CadastraFarmaceuticaController(CriaNovaFarmaceutica service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaFarmaceuticaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        var farmaceutica = service.cadastraNovaFarmceutica(request);


        URI location = uriBuilder.path("/farmaceuticas/{id}")
                .buildAndExpand(farmaceutica.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
