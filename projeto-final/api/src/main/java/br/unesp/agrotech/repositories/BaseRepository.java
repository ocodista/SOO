package br.unesp.agrotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T> extends JpaRepository<T, Long>  {
}
