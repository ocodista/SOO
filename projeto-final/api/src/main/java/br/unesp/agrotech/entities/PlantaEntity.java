package br.unesp.agrotech.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPlantio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idNicho")
    private NichoEntity nicho;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idCategoriaPlanta")
    private CategoriaPlantaEntity categoriaPlanta;
}
