package com.simulacro.simu.repository;

import com.simulacro.simu.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reservaRepository extends JpaRepository<Reserva,Long> {
}
