package br.com.fiap.easyfix.controller;

import br.com.fiap.easyfix.model.PrestadorServico;
import br.com.fiap.easyfix.repository.PrestadorServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("prestador")
public class PrestadorServicoController {

    @Autowired
    private PrestadorServicoRepository prestadorServicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPrestador(@RequestBody @Valid PrestadorServico prestadorServico, UriComponentsBuilder uriComponentsBuilder) {
        prestadorServicoRepository.save(new PrestadorServico(prestadorServico));
        var uri = uriComponentsBuilder.path("prestador/{id}").buildAndExpand(prestadorServico.getId()).toUri();
        return ResponseEntity.created(uri).body(prestadorServico);
    }
}
