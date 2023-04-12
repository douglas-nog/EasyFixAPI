package br.com.fiap.easyfix.controller;

import br.com.fiap.easyfix.model.PrestadorServico;
import br.com.fiap.easyfix.repository.PrestadorServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<PrestadorServico>> listarPrestador(Pageable pageable) {
        var page = prestadorServicoRepository.findAll(pageable).map(PrestadorServico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity listarPrestadorPorId(@PathVariable Long id) {
        var resultSearchOne = prestadorServicoRepository.findById(id).get();
        return ResponseEntity.ok(resultSearchOne);
    }
}
