package br.com.fiap.easyfix.controller;

import br.com.fiap.easyfix.model.TipoServico;
import br.com.fiap.easyfix.repository.TipoServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
