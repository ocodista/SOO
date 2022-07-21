package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NichoDTO {
    private int posicaoHorizontal;
    private Long idPrateleira;
}
