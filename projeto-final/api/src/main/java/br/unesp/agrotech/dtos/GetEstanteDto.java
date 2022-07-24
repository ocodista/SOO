package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEstanteDto {
    private Long id;
    private int qtdPrateleiras;
    private int qtdNichosPorPrateleira;
    private String descricao;

    private Set<PrateleiraDTO> prateleiras;

    public String toString() {
        return "Quantidade prateleiras: " + qtdPrateleiras + "\nQtdNichosPorPrateleira: " + qtdNichosPorPrateleira + "\nDescricao: " + descricao;
    }
}
