package br.com.fiap.easyfix.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @SequenceGenerator(name = "cliente", sequenceName = "sq_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @Id
    private Long id;

    @Column(name = "ds_nome")
    @NotBlank
    private String nome;

    @NotBlank
    @Column(name = "nr_cpf")
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
    private String cpf;

    @NotBlank
    @Column(name = "ds_email")
    private String email;

    @NotBlank
    @Column(name = "nr_telefone")
    @Pattern(regexp = "\\d{11}")
    private String telefone;

    public Cliente(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }
}
