package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrateleiraDTO {
    private int posicaoVertical;
    private Long idEstante;

    private Set<NichoDTO> nichos;
}
