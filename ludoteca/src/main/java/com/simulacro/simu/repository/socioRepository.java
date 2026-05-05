package com.simulacro.simu.repository;

import com.simulacro.simu.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface socioRepository extends JpaRepository<Socio,Long> {
}
