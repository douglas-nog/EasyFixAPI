package br.com.fiap.easyfix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

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

    @NotBlank
    @Column(name = "ds_tipo_servico")
    private String nome;

    @OneToMany
    @JoinColumn(name = "id_tipo_servico")
    @JsonIgnore
    private List<TipoServico> tipoServico;

    public TipoServico(TipoServico tipoServico) {
        this.id = tipoServico.id;
        this.nome = tipoServico.nome;
    }
}
