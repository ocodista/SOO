package br.unesp.agrotech.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prateleira")
public class PrateleiraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posicaoVertical")
    private int posicaoVertical;

    @JoinColumn(name = "idEstante")
    private Long idEstante;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(name="idEstante", insertable = false, updatable = false)
    @JsonIgnore
    private EstanteEntity estante;

    @OneToMany(fetch = EAGER, cascade = CascadeType.ALL)
    private Set<NichoEntity> nichos;
}
