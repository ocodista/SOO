package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NichoDTO {
    private Long id;
    private int posicaoHorizontal;
    private Long idPrateleira;

    private Set<GetDispositivoDTO> dispositivos;
}
