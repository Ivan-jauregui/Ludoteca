package com.ludoteca.repository;

import com.ludoteca.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocioRepository  extends JpaRepository<Socio,Long> {
    void deleteByDni(String dni);

    Optional<Socio> findByDni(String dni);
}
