package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDispositivoDTO {
    private Long id;
    private Double value;

    private TipoDispositivoDTO tipoDispositivo;

    private CategoriaDispositivoDTO categoriaDispositivo;
    private Long idNicho;
}
