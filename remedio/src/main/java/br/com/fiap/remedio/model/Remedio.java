package br.com.fiap.remedio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_remedio")
    private Long numeroRemedio;

    @Column(name = "nome_remedio")
    private String nomeRemedio;

    @Column(name = "tipo_remedio")
    private String tipoRemedio;


    @Positive
    private BigDecimal valor;

}
