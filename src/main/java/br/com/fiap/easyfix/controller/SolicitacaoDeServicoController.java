package br.com.fiap.easyfix.controller;


import br.com.fiap.easyfix.model.SolicitacaoDeServico;
import br.com.fiap.easyfix.repository.SolicitacaoDeServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
