package br.com.fiap.farmacia.dto;

import br.com.fiap.farmacia.model.Farmacia;

public record FarmaciaExibicaoDTO(

        Long registroFarmacia,
        String nomeFarmacia,
        Long numeroCnpj,
        String enderecoFarmacia
) {
    public FarmaciaExibicaoDTO(Farmacia farmacia){
        this(
                farmacia.getRegistroFarmacia(),
                farmacia.getNomeFarmacia(),
                farmacia.getNumeroCnpj(),
                farmacia.getEnderecoFarmacia()
        );
    }

}
