package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.agrotech.entities.Estante;

@Repository
public interface EstanteRepository extends JpaRepository<Estante, Long> {
}
