package br.unesp.agrotech.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idPrateleira", insertable = false, updatable = false)
    @JsonIgnore
    private PrateleiraEntity prateleira;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DispositivoEntity> dispositivos;
}
