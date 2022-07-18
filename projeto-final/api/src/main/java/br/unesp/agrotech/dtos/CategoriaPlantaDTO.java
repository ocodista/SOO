package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaPlantaDTO {
    private String nome;
    private String tipoTerra;
    private Float temperaturaIdeal;
    private Float consumoAguaPorDia;
}
