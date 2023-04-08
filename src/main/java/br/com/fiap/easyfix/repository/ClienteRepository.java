package br.com.fiap.easyfix.repository;

import br.com.fiap.easyfix.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
