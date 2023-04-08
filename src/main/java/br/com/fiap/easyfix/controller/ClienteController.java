package br.com.fiap.easyfix.controller;


import br.com.fiap.easyfix.model.Cliente;
import br.com.fiap.easyfix.repository.ClienteRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriComponentsBuilder) {
        clienteRepository.save(new Cliente(cliente));
        var uri = uriComponentsBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> listarClientes(Pageable pageable) {
        var page = clienteRepository.findAll(pageable).map(Cliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity listarClientesPorId(@PathVariable Long id) {
        var resultSearchOne = clienteRepository.findById(id).get();
        return ResponseEntity.ok(resultSearchOne);
    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletarcliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
