package com.simulacro.simu.models;

import com.simulacro.simu.Estado;
import com.simulacro.simu.validator.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha_reserva ;
    @PrePersist
    public void prePersist() {
        if (this.fecha_reserva == null ) {
            this.fecha_reserva = LocalDateTime.now();
        }
    }

    private LocalDateTime fecha_retiro;

    private Integer cantidad;

    private Estado estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "socio_id")
    private Socio socio;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id")
    private Juego juego;
}