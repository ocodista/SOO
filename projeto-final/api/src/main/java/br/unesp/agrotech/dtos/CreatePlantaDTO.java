package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlantaDTO {
    private String nome;
    private Date dataPlantio;
    private Long idCategoriaPlanta;
    private long idNicho;
}
