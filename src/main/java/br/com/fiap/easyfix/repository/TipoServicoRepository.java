package br.com.fiap.easyfix.repository;

import br.com.fiap.easyfix.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
