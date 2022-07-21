package br.unesp.agrotech.repositories;

import br.unesp.agrotech.entities.Planta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepository extends JpaRepository<Planta, Long> {
}
