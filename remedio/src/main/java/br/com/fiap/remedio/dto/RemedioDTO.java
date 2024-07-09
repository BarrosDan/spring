package br.com.fiap.remedio.dto;

import java.math.BigDecimal;

public record RemedioDTO (
        Long numeroRemedio,
        String nomeRemedio,
        String tipoRemedio,
        BigDecimal valor
){



}
