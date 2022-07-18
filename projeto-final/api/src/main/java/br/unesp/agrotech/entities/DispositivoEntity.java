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

    @Column(name = "value")
    private Double value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idEstante")
    private EstanteEntity estante;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idTipoDispositivo")
    private TipoDispositivoEntity tipoDispositivo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idCategoriaDispositivo")
    private CategoriaDispositivoEntity categoriaDispositivo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idNicho")
    private NichoEntity nicho;
}
