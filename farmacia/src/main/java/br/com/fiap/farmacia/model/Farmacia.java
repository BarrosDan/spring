package br.com.fiap.farmacia.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tbl_farmacia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroFarmacia;

    @Column(name = "nome_farmacia")
    @NotNull
    private String nomeFarmacia;

    @Column(name = "numero_cnpj")
    @NotNull
    private Long numeroCnpj;

    @Column(name = "endereco_farmacia")
    @NotNull
    private String enderecoFarmacia;

}
