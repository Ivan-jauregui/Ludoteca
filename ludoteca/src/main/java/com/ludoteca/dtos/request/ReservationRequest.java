package com.ludoteca.dtos.request;

import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.enums.ReservationStatus;
import com.ludoteca.models.Socio;
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
public class ReservationRequest {

    @FutureOrPresent
    private LocalDateTime retirementDate;

    @NotNull(message = "La cantidad es requerida")
    @Positive(message = "La cantidad debe ser mayor a cero")
    private Integer quantity;

    @NotNull(message = "El id de socio es requerido")
    private Long socioId;

    @NotNull(message = "El id del juego es requerido")
    private Long gameId;

}
