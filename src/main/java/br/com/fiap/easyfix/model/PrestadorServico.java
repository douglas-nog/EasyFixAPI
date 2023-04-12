package br.com.fiap.easyfix.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity(name = "prestadorServico")
@Table(name = "tb_ef_prestador_servico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PrestadorServico {

    @Column(name = "id_prestador", nullable = false)
    @Id
    @SequenceGenerator(name = "prestador", sequenceName = "sq_prestador", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestador")
    private Long id;

    @Column(name = "nm_prestador")
    @NotBlank
    private String nome;

    @Column(name = "ds_cnpj")
    @NotBlank
    @Pattern(regexp = "\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}")
    private String cnpj;

    @Column(name = "ds_email")
    @NotBlank
    private String email;

}
