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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private Long id;

    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idEstante", nullable = false)
    private EstanteEntity estante;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idTipoDispositivo", nullable = false)
    private TipoDispositivoEntity tipoDispositivo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idCategoriaDispositivo", nullable = false)
    private CategoriaDispositivoEntity categoriaDispositivo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idNicho", nullable = false)
    private NichoEntity nicho;
}
