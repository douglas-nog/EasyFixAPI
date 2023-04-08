package br.com.fiap.easyfix.model;

public record DadosTipoServico(
        String nome
) {
    public DadosTipoServico(TipoServico tipoServico) {
        this(tipoServico.getNome());
    }
}
