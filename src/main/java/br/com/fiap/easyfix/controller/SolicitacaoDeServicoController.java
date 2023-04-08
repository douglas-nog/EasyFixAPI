package br.com.fiap.easyfix.controller;


import br.com.fiap.easyfix.model.SolicitacaoDeServico;
import br.com.fiap.easyfix.repository.SolicitacaoDeServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("solicitacao")
public class SolicitacaoDeServicoController {

    @Autowired
    private SolicitacaoDeServicoRepository solicitacaodeServicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarSolicitacaoDeServico(@RequestBody SolicitacaoDeServico solicitacaoDeServico, UriComponentsBuilder uriComponentsBuilder) {
        solicitacaodeServicoRepository.save(new SolicitacaoDeServico(solicitacaoDeServico));
        var uri = uriComponentsBuilder.path("solicitacao/{id}").buildAndExpand(solicitacaoDeServico.getId()).toUri();
        return ResponseEntity.created(uri).body(solicitacaoDeServico);
    }

    @GetMapping
    public  ResponseEntity<Page<SolicitacaoDeServico>> listarSolicitacoesDeServico(Pageable pageable) {
        var page = solicitacaodeServicoRepository.findAll(pageable).map(SolicitacaoDeServico::new);
        return ResponseEntity.ok(page);
    }
}
