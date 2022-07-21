package br.unesp.agrotech.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantaDTO {
    private String nome;
    private Date dataPlantio;
    private Long idCategoriaPlanta;
    private long idNicho;
}
