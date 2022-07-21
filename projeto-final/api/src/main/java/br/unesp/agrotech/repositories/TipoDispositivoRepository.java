package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.agrotech.entities.TipoDispositivo;

@Repository
public interface TipoDispositivoRepository extends JpaRepository<TipoDispositivo, Long> {
}
