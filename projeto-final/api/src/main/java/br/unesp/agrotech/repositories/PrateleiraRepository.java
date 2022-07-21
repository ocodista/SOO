package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.agrotech.entities.Prateleira;

public interface PrateleiraRepository extends JpaRepository<Prateleira, Long> {
}
