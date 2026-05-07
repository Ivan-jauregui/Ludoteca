package com.simulacro.simu.Dtos;

import com.simulacro.simu.models.Juego;
import com.simulacro.simu.models.Socio;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class reservaDTO {
    private LocalDateTime fecha_reserva;
    private LocalDateTime fecha_retiro;
    private socioDTO socio;
    private JuegoDTO juego;

}
