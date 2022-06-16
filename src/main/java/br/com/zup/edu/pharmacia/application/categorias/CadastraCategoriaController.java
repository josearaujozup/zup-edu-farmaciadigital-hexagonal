package br.com.zup.edu.pharmacia.application.categorias;

import br.com.zup.edu.pharmacia.domain.categorias.CadastraNovaCategoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CadastraCategoriaController {

    private final CadastraNovaCategoria service;

    public CadastraCategoriaController(CadastraNovaCategoria service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovaCategoriaRequest request,
                                      UriComponentsBuilder uriBuilder) {

        var categoria = service.cadastraNovaCategoria(request.getNome());


        URI location = uriBuilder.path("/categorias/{id}")
                                 .buildAndExpand(categoria.getId())
                                 .toUri();

        return ResponseEntity.created(location).build();
    }

}
