package com.ludoteca.dtos.response;

import com.ludoteca.enums.ReservationStatus;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ReservationResponse {
    private LocalDateTime reservationDate;

    private LocalDateTime retirementDate;

    private ReservationStatus status;

    private SocioResponse socio;

    private GameResponse game;
}
