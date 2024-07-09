package br.com.fiap.farmacia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmaciaDTO {

    private Long registroFarmacia;
    private String nomeFarmacia;
    private Long numeroCnpj;
    private String enderecoFarmacia;

}
