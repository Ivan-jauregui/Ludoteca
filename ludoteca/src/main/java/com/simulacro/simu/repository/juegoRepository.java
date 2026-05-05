package com.simulacro.simu.repository;

import com.simulacro.simu.models.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface juegoRepository extends JpaRepository<Juego,Long> {
}
