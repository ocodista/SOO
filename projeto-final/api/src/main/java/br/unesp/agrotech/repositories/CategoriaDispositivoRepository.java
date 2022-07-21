package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.agrotech.entities.CategoriaDispositivo;

@Repository
public interface CategoriaDispositivoRepository extends JpaRepository<CategoriaDispositivo, Long> {
}
