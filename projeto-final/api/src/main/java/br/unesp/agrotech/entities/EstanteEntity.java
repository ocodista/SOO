package br.unesp.agrotech.entities;

import java.util.Set;

import javax.persistence.*;

import lombok.*;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PrateleiraEntity> prateleiras;
}
