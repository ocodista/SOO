package com.ativ7.api.jpa.repositories;

import com.ativ7.api.jpa.entities.LocacaoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoJpaRepository extends JpaRepository<LocacaoEntity, Long> {
}
