package br.com.fiap.easyfix.controller;

import br.com.fiap.easyfix.model.TipoServico;
import br.com.fiap.easyfix.repository.TipoServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tipo-servico")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTipoServico(@RequestBody @Valid TipoServico tipoServico, UriComponentsBuilder uriComponentsBuilder) {
        tipoServicoRepository.save(new TipoServico(tipoServico));
        var uri= uriComponentsBuilder.path("tipo-servico/{id}").buildAndExpand(tipoServico.getId()).toUri();
        return ResponseEntity.created(uri).body(tipoServico);
    }

    @GetMapping
    public ResponseEntity<Page<TipoServico>> buscarTipoDeServiço(Pageable pageable) {
        var page = tipoServicoRepository.findAll(pageable).map(TipoServico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity buscarTipoDeServiçoPorId(@PathVariable Long id) {
        var resultSearchOne = tipoServicoRepository.findById(id).get();
        return ResponseEntity.ok(resultSearchOne);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizarTipoServico(@RequestBody @Valid TipoServico tipoServico, @PathVariable Long id) {
        tipoServico.setId(id);
        tipoServicoRepository.save(tipoServico);
        return ResponseEntity.ok(tipoServico);
    }


}
