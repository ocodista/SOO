package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.agrotech.entities.LocacaoEntity;

@Repository
public interface LocacaoJpaRepository extends JpaRepository<LocacaoEntity, Long> {
}
