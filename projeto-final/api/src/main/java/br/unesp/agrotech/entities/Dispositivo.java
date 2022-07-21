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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dispositivo")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private Double value;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "estante_id")
    private Estante estante;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "tipoDispositivo_id")
    private TipoDispositivo tipoDispositivo;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "categoriaDispositivo_id")
    private CategoriaDispositivo categoriaDispositivo;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "nicho_id")
    private Nicho nicho;
}
