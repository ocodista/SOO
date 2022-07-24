package br.unesp.agrotech.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @Column(name = "idNicho")
    private Long idNicho;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idNicho", updatable = false, insertable = false)
    @JsonIgnore
    private NichoEntity nicho;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategoriaPlanta")
    private CategoriaPlantaEntity categoriaPlanta;
}
