package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlantaDTO {
    private String nome;
    private Date dataPlantio;

    private CategoriaPlantaDTO categoriaPlanta;
    private long idNicho;
}
