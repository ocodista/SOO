package br.unesp.agrotech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planta")
public class PlantaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataPlantio")
    private int dataPlantio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idNicho")
    private NichoEntity nicho;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idCategoriaPlanta")
    private CategoriaPlantaEntity categoriaPlanta;
}
