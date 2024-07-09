package br.com.fiap.remedio.dto;

import br.com.fiap.remedio.model.Remedio;

import java.math.BigDecimal;

public record RemedioExibicaoDTO(
        Long numeroRemedio,
        String nomeRemedio,
        String tipoRemedio,
        BigDecimal valor
) {
    public RemedioExibicaoDTO(Remedio remedio){
        this(
                remedio.getNumeroRemedio(),
                remedio.getNomeRemedio(),
                remedio.getTipoRemedio(),
                remedio.getValor()
        );
    }
}
