package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstanteDispositivoDTO {
    private Double value;
    private TipoDispositivoDTO tipoDispositivo;
    private NichoDTO nicho;
    private CategoriaDispositivoDTO categoriaDispositivo;
}
