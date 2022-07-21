package br.unesp.agrotech.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estante")
public class Estante {
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

    @OneToMany(mappedBy = "estante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Prateleira> prateleiras = new HashSet<>();
}
