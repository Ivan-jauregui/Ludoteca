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
    @NotNull(groups = Group.Actualizar.class, message = "El ID es requerido para actualizar")
    private Long id;

    @Builder.Default
    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class},message = "Error en la fecha")
    private LocalDateTime fecha_reserva = LocalDateTime.now();

    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "La fecha de retiro es requerida")
    @FutureOrPresent(groups = Group.Crear.class, message = "La fecha de retiro no puede ser en el pasado")
    private LocalDateTime fecha_retiro;

    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class},message = "La cantidad es requerida")
    @Positive(message = "El numero debe ser positivo")
    private Integer cantidad;

    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El estado es requerido")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El socio es obligatorio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El juego es obligatorio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id")
    private Juego juego;
}