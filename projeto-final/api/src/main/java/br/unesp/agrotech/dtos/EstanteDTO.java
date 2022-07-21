package br.unesp.agrotech.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstanteDTO {
    private int qtdPrateleiras;
    private int qtdNichosPorPrateleira;
    private String descricao;
    private List<PrateleiraDTO> prateleiras;
}
