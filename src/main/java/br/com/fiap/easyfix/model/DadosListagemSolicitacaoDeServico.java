package br.com.fiap.easyfix.model;

public record DadosListagemSolicitacaoDeServico(

        Long id,

        String descricaoServico,

        DadosTipoServico tipoServico
) {
        public DadosListagemSolicitacaoDeServico(SolicitacaoDeServico solicitacaoDeServico) {
            this(solicitacaoDeServico.getId(), solicitacaoDeServico.getDescricaoServico(), );
        }

}
