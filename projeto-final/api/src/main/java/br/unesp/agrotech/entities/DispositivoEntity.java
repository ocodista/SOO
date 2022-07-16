package br.unesp.agrotech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dispositivo")
public class DispositivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne
    private EstanteEntity estante;

    @ManyToOne
    private TipoDispositivoEntity tipoDispositivo;

    @ManyToOne
    private CategoriaDispositivoEntity categoriaDispositivo;

    @Column(name = "idNicho", nullable = false)
    private Long idNicho;
}
