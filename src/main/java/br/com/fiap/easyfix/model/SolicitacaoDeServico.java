package br.com.fiap.easyfix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @Column(name = "ds_servico")
    private String descricaoServico;


    @ManyToOne
    @JoinColumn(name = "id_tipo_servico", referencedColumnName = "id", nullable = false)
    @Valid
    @NotNull
    private TipoServico tipoServico;

    public SolicitacaoDeServico(SolicitacaoDeServico solicitacaoDeServico) {
        this.id = solicitacaoDeServico.id;
        this.tipoServico = new TipoServico(solicitacaoDeServico.tipoServico);
        this.descricaoServico = solicitacaoDeServico.descricaoServico;
    }

}
