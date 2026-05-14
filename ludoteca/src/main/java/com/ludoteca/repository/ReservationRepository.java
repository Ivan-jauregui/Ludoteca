package com.ludoteca.repository;

import com.ludoteca.enums.ReservationStatus;
import com.ludoteca.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findBySocio_Name(String name);
    List<Reservation> findByStatus(ReservationStatus status);
}
