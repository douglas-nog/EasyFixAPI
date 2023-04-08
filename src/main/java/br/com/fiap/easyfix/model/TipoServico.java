package br.com.fiap.easyfix.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tipoServico")
@Table(name = "tb_tipo_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoServico {

    @SequenceGenerator(name = "tipoServico", sequenceName = "sq_tipo_servico", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoServico")
    @Id
    private Long id;

    @Column(name = "ds_tipo_servico")
    private String nomeServico;

    public TipoServico(TipoServico tipoServico) {
        this.id = tipoServico.id;
        this.nomeServico = tipoServico.nomeServico;
    }
}
