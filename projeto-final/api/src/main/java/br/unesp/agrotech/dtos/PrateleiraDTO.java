package br.unesp.agrotech.dtos;

import java.util.List;

import br.unesp.agrotech.entities.Nicho;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrateleiraDTO {
    private int posicaoVertical;
    private Long idEstante;
    private List<NichoDTO> nichos;
}
