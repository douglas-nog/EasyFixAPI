package br.com.fiap.easyfix.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "solicitacaoDeServico")
@Table(name = "tb_soliCItacao_de_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SolicitacaoDeServico {

    @Id
    @SequenceGenerator(name = "solicitacaoDeServico", sequenceName = "sq_solicitacao_de_servico", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitacaoDeServico")
    @Column(name = "id_solicitacao")
    private Long id;

    @Column(name = "ds_tipo_servico")
    private String tipoServico;

    @Column(name = "ds_servico")
    private String descricaoServico;

    public SolicitacaoDeServico(SolicitacaoDeServico solicitacaoDeServico) {
        this.id = solicitacaoDeServico.id;
        this.tipoServico = solicitacaoDeServico.tipoServico;
        this.descricaoServico = solicitacaoDeServico.descricaoServico;
    }
}