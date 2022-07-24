package br.unesp.agrotech.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nicho")
public class NichoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posicaoHorizontal")
    private int posicaoHorizontal;

    @Column(name = "idPrateleira")
    private Long idPrateleira;
    @ManyToOne
    @JoinColumn(name = "idPrateleira", insertable = false, updatable = false)
    private PrateleiraEntity prateleira;
    @OneToMany
    private List<DispositivoEntity> dispositivos;
}
