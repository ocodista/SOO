package br.unesp.agrotech.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prateleira")
public class Prateleira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posicaoVertical")
    private int posicaoVertical;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

    @OneToMany(mappedBy = "prateleira", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Nicho> nichos = new HashSet<>();
}
