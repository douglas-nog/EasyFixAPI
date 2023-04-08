package br.com.fiap.easyfix.controller;


import br.com.fiap.easyfix.model.Cliente;
import br.com.fiap.easyfix.repository.ClienteRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriComponentsBuilder) {
        clienteRepository.save(new Cliente(cliente));
        var uri = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }
}
