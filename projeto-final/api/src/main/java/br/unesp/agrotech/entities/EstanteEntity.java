package br.unesp.agrotech.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estante")
public class EstanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "qtdPrateleiras", nullable = false)
    private int qtdPrateleiras;

    @Column(name = "qtdNichosPorPrateleira", nullable = false)
    private int qtdNichosPorPrateleira;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "estante")
    private Set<DispositivoEntity> dispositivos;

    @OneToMany(mappedBy = "estante")
    private Set<PrateleiraEntity> prateleiras;
}
