package com.ativ7.api.repositories.jpa;

import com.ativ7.api.entities.Locacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoJpaRepository extends JpaRepository<Locacao, Long> {
}
