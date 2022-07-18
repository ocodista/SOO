package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoDTO {
    private Double value;
    private Long idEstante;
    private Long idTipoDispositivo;
    private Long idNicho;
    private Long idCategoriaDispositivo;
}
